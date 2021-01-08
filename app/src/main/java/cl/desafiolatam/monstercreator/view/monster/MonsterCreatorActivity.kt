package cl.desafiolatam.monstercreator.view.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterImage
import cl.desafiolatam.monstercreator.view.monsteravatars.MonsterAdapter
import cl.desafiolatam.monstercreator.viewmodel.MonsterCreatorViewModel

private var monsterList = ArrayList<MonsterImage>()
lateinit var adapter: MonsterAdapter
private lateinit var monsterViewModel: MonsterCreatorViewModel
class MonsterCreatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_creator)
        adapter = MonsterAdapter(monsterList)

        val monsterViewModel: MonsterCreatorViewModel by activityViewModels()

    }
    // in this activity must place a recyclerView with all the monster on the DB

}
