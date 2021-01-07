package cl.desafiolatam.monstercreator.model

import android.content.Context
import cl.desafiolatam.monstercreator.model.db.MonsterRoomDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Cristian Vidal on 2019-09-26.
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MonsterRepository(context: Context) {
    var monsterDatabase = MonsterRoomDataBase.getDatabase(context)
    var listMonster = monsterDatabase.monsterDao().getAllMonsters()

    fun loadDataBase(){
        if(isDatabaseIsEmpty()){
        monsterDatabase.monsterDao().insertMonster()
       }
    }

    fun isDatabaseIsEmpty(): Boolean {
        var result = false
        if(monsterDatabase.monsterDao().counMonster() == 0){
            result = true
        }
        return result
    }

    fun quoteConverter(listMonster: List<Monster>): List<Monster>{
        return listMonster.map { monster -> Monster(monster.attributes, monster.monsterPoints, monster.name, monster.drawable) }
    }
    fun saveDatabase(Monster: List<Monster>){
        monsterDatabase.monsterDao().insertMonster()
        }

    }
