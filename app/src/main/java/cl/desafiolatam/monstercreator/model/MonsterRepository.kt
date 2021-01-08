package cl.desafiolatam.monstercreator.model

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.model.db.MonsterRoomDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        }

    override fun getAllMonster(): LiveData<List<Monster>> {
       return listMonster
    }

    override fun clearAllMonster() {
        //TODO monsterDatabase.monsterDao().deleteAllMonsters()
    }
}

    interface MonsterRepositoryInterface {
        fun saveMonsterInDatabase(monster: Monster)
        fun getAllMonster(): LiveData<List<Monster>>
        fun clearAllMonster()
    }
