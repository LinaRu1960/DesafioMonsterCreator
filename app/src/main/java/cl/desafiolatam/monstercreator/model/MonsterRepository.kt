package cl.desafiolatam.monstercreator.model

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication

/**
 * Created by Cristian Vidal on 2019-09-26.
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MonsterRepository: MonsterRepositoryInterface{

        var monsterDatabase = MonsterCreatorApplication.database
        var listMonster = monsterDatabase.monsterDao().getAllMonsters()

    override fun saveMonsterInDatabase(monster: Monster){
        monsterDatabase.monsterDao().insertMonster(monster)
        Log.d("MonsterRepository", "saveMonsterInDatabase: $monster")
    }

    override fun getAllMonster(): LiveData<List<Monster>> {
       return listMonster
    }

    override fun clearAllMonster(value: List<Monster>) {
        value.forEach { monsterDatabase.monsterDao().deleteMonster(it)}
    }
}

    interface MonsterRepositoryInterface {
        fun saveMonsterInDatabase(monster: Monster)
        fun getAllMonster(): LiveData<List<Monster>>
        fun clearAllMonster(value: List<Monster>)
    }
