package br.edu.ifsp.ads.pdm.splitthebill.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.ifsp.ads.pdm.splitthebill.model.dao.IntegranteRoomDao
import br.edu.ifsp.ads.pdm.splitthebill.model.entity.Integrante

@Database(entities = [Integrante::class], version = 1)
abstract class IntegranteRoomDaoDatabase: RoomDatabase() {
    abstract fun getIntegranteRoomDao(): IntegranteRoomDao
}