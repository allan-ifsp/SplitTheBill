package br.edu.ifsp.ads.pdm.splitthebill.controller

import android.os.AsyncTask
import androidx.room.Room
import br.edu.ifsp.ads.pdm.splitthebill.model.dao.IntegranteRoomDao
import br.edu.ifsp.ads.pdm.splitthebill.model.database.IntegranteRoomDaoDatabase
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante
import br.edu.ifsp.ads.pdm.splitthebill.view.MainActivity

class IntegranteRoomController(private val mainActivity: MainActivity) {
    private val integranteDaoImpl: IntegranteRoomDao by lazy {
        Room.databaseBuilder(
            mainActivity,
            IntegranteRoomDaoDatabase::class.java,
            IntegranteRoomDao.INTEGRANTE_DATABASE_FILE
        ).build().getIntegranteRoomDao()
    }

    fun inserirIntegrante(integrante: Integrante) {
        Thread {
            integranteDaoImpl.criarIntegrante(integrante)
            getIntegrantes()
        }.start()
    }

    fun getIntegrante(id: Int) = integranteDaoImpl.receberIntegrante(id)

    fun getIntegrantes() {
        object: AsyncTask<Unit, Unit, MutableList<Integrante>>(){
            override fun doInBackground(vararg params: Unit?): MutableList<Integrante> {
                val returnList = mutableListOf<Integrante>()
                returnList.addAll(integranteDaoImpl.receberIntegrantes())
                return returnList
            }

            override fun onPostExecute(result: MutableList<Integrante>?) {
                super.onPostExecute(result)
                if (result != null){
                    mainActivity.atualizarListaIntegrantes(result)
                }
            }
        }.execute()
    }

    fun editarIntegrante(integrante: Integrante) {
        Thread {
            integranteDaoImpl.atualizarIntegrante(integrante)
            getIntegrantes()
        }.start()
    }

    fun removerIntegrante(integrante: Integrante) {
        Thread {
            integranteDaoImpl.deletarIntegrante(integrante)
            getIntegrantes()
        }.start()
    }
}