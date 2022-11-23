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
        var integranteTileView = convertView
        if (integranteTileView == null) {
            // Inflo uma nova célula
            integranteTileView =
                (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                    R.layout.tile_racha,
                    parent,
                    false
                )

            val integranteTileHolder = RachaAdapter.RachaTileHolder(
                integranteTileView.findViewById(R.id.nomeTv),
                integranteTileView.findViewById(R.id.valorPagoTv),
                integranteTileView.findViewById(R.id.comprasTv),
                integranteTileView.findViewById(R.id.saldoTv),
            )
            integranteTileView.tag = integranteTileHolder
        }

        with(integranteTileView?.tag as RachaAdapter.RachaTileHolder) {
            nomeTv.text = integrante.nome
            valorPagoTv.text = integrante.valorPago
            comprasTv.text = integrante.compras
            saldoTv.text = integrante.saldo
        }

        return integranteTileView

    }
}