package cl.desafiolatam.monstercreator.view.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.inflate
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.databinding.ActivityMonsterCreatorBindingImpl
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterAttributes
import cl.desafiolatam.monstercreator.model.MonsterGenerator
import cl.desafiolatam.monstercreator.model.MonsterImage
import cl.desafiolatam.monstercreator.view.monsteravatars.MonsterAdapter
import cl.desafiolatam.monstercreator.viewmodel.MonsterCreatorViewModel

private var monsterList = ArrayList<MonsterImage>()
lateinit var adapter: MonsterAdapter
private lateinit var monsterViewModel: MonsterCreatorViewModel
class MonsterCreatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMonsterCreatorBindingImpl.inflate(layoutInflater)
        setContentView(binding.root)
        val monsterGenerator = MonsterGenerator()
        monsterViewModel = MonsterCreatorViewModel(application) //TODO
        var newAttributes = MonsterAttributes()
        binding.saveButton.setOnClickListener { //Aquí creamos un monstruo
               val monsterName = binding.nameEditText.text.toString()
                newAttributes.evilness = binding.endurance.selectedItem.toString().toInt()
                newAttributes.intelligence = binding.intelligence.selectedItem.toString().toInt()
                newAttributes.ugliness = binding.strength.selectedItem.toString().toInt()
                val drawable = 0
                val monster = monsterGenerator.generateMonster(newAttributes, monsterName, drawable)
                monsterViewModel.insertMonster(monster)
                Log.d("MonsterCreatorActivity", "$monster")
        }
    }

    // in this activity must place a recyclerView with all the monster on the DB

}
