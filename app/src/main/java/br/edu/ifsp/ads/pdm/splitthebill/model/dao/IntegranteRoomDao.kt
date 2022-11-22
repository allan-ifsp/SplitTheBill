package br.edu.ifsp.ads.pdm.splitthebill.model.dao

import androidx.room.*
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante

@Dao
interface IntegranteRoomDao {
    companion object Constant {
        const val INTEGRANTE_DATABASE_FILE = "integrantes_room"
        const val INTEGRANTE_TABLE = "integrante"
        const val ID_COLUMN = "id"
        const val NOME_COLUMN = "nome"
    }

    @Insert
    fun criarIntegrante(integrante: Integrante)

    @Query("SELECT * FROM $INTEGRANTE_TABLE WHERE $ID_COLUMN = :id")
    fun receberIntegrante(id: Int): Integrante?

    @Query("SELECT * FROM $INTEGRANTE_TABLE ORDER BY $NOME_COLUMN")
    fun receberIntegrantes(): MutableList<Integrante>

    @Update
    fun atualizarIntegrante(integrante: Integrante): Int

    @Delete
    fun deletarIntegrante(integrante: Integrante): Int
}