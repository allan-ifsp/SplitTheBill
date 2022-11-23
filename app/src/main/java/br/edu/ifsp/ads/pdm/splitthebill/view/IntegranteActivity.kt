package br.edu.ifsp.ads.pdm.splitthebill.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.ads.pdm.splitthebill.databinding.ActivityIntegranteBinding
import br.edu.ifsp.ads.pdm.splitthebill.model.Constant
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante

class IntegranteActivity: AppCompatActivity() {
    private val aib: ActivityIntegranteBinding by lazy {
        ActivityIntegranteBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(aib.root)

        val integranteRecebido = intent.getParcelableExtra<Integrante>(Constant.EXTRA_INTEGRANTE)
        integranteRecebido?.let{ _integranteRecebido ->
            with(aib) {
                with(_integranteRecebido) {
                    nomeEt.setText(nome)
                    valorPagoEt.setText(valorPago)
                    comprasEt.setText(compras)
                }
            }
        }
        val viewIntegrante = intent.getBooleanExtra(Constant.VIEW_INTEGRANTE, false)
        if (viewIntegrante) {
            aib.nomeEt.isEnabled = false
            aib.valorPagoEt.isEnabled = false
            aib.comprasEt.isEnabled = false
            aib.saveBt.visibility = View.GONE
        }

        aib.saveBt.setOnClickListener {
            val integrante = Integrante(
                id = integranteRecebido?.id,
                nome = aib.nomeEt.text.toString(),
                valorPago = aib.valorPagoEt.text.toString(),
                compras = aib.comprasEt.text.toString(),
                saldo = "0"
            )
            val resultIntent = Intent()
            resultIntent.putExtra(Constant.EXTRA_INTEGRANTE, integrante)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}