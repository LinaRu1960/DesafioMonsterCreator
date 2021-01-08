package cl.desafiolatam.monstercreator.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterRepository
import cl.desafiolatam.monstercreator.model.MonsterRepositoryInterface

/**
 * Created by Cristian Vidal on 2019-10-02.
 */
class AllMonsterViewModel(
    private val monsterRepository: MonsterRepositoryInterface = MonsterRepository()
): ViewModel() {
    private val allMonsterLiveData = monsterRepository.getAllMonster()
    fun getAllMonster(): LiveData<List<Monster>> = monsterRepository.getAllMonster()
    fun clearAllMonster() = allMonsterLiveData.value?.let { monsterRepository.clearAllMonster(it) }
}