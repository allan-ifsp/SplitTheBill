package br.edu.ifsp.ads.pdm.splitthebill.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.ads.pdm.splitthebill.R
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante

class RachaAdapter (
    context: Context,
    private val listaIntegrante: MutableList<Integrante>
) : ArrayAdapter<Integrante> (context, R.layout.tile_racha, listaIntegrante){
    private data class RachaTileHolder(val nomeTv: TextView,
                                            val valorPagoTv: TextView,
                                            val comprasTv: TextView,
                                            val saldoTv: TextView )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val integrante = listaIntegrante[position]
        var rachaTileView = convertView
        if (rachaTileView == null) {
            // Inflo uma nova célula
            rachaTileView =
                (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                    R.layout.tile_racha,
                    parent,
                    false
                )

            val rachaTileHolder = RachaAdapter.RachaTileHolder(
                rachaTileView.findViewById(R.id.nomeTv),
                rachaTileView.findViewById(R.id.valorPagoTv),
                rachaTileView.findViewById(R.id.comprasTv),
                rachaTileView.findViewById(R.id.saldoTv),
            )
            rachaTileView.tag = rachaTileHolder
        }

        with(rachaTileView?.tag as RachaAdapter.RachaTileHolder) {
            nomeTv.text = integrante.nome
            valorPagoTv.text = integrante.valorPago
            comprasTv.text = integrante.compras
            saldoTv.text = integrante.saldo
        }

        return rachaTileView

    }
}