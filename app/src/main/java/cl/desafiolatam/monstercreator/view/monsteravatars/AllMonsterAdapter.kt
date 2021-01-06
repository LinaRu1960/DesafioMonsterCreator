package cl.desafiolatam.monstercreator.view.monsteravatars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.monstercreator.databinding.MonsterItemBinding
import cl.desafiolatam.monstercreator.model.Monster

class AllMonsterAdapter (private val listMonster: MutableList <Monster>): RecyclerView.Adapter<AllMonsterVH>(){
    private val monsterList = mutableListOf<Monster>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMonsterVH {
        val binding= MonsterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllMonsterVH (binding)
    }

    override fun onBindViewHolder(holder: AllMonsterVH, position: Int) {
        val monster = monsterList[position]
        holder.monsterName.text=monster.name

    }

    override fun getItemCount(): Int {
        return monsterList.size
    }

}

class AllMonsterVH (itemView: MonsterItemBinding): RecyclerView.ViewHolder(itemView.root) {
   val monsterName: TextView= itemView.name
}
