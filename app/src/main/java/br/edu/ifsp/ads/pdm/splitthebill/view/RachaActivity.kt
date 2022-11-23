package br.edu.ifsp.ads.pdm.splitthebill.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.ads.pdm.splitthebill.adapter.IntegranteAdapter
import br.edu.ifsp.ads.pdm.splitthebill.adapter.RachaAdapter
import br.edu.ifsp.ads.pdm.splitthebill.controller.IntegranteRoomController
import br.edu.ifsp.ads.pdm.splitthebill.databinding.ActivityIntegranteBinding
import br.edu.ifsp.ads.pdm.splitthebill.databinding.ActivityRachaBinding
import br.edu.ifsp.ads.pdm.splitthebill.model.Constant
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante

class RachaActivity: AppCompatActivity() {
    private val arb: ActivityRachaBinding by lazy {
        ActivityRachaBinding.inflate(layoutInflater)
    }

    private val listaIntegrantes: MutableList<Integrante> = mutableListOf()
    private lateinit var rachaAdapter: RachaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(arb.root)

        val viewIntegrantes = intent.getBooleanExtra(Constant.VIEW_INTEGRANTES, false)
        if (viewIntegrantes) {
            rachaAdapter = RachaAdapter(this, listaIntegrantes)
            arb.rachaLv.adapter = rachaAdapter
        }
    }
}