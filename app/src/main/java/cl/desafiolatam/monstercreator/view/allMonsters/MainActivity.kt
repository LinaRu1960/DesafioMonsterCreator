package cl.desafiolatam.monstercreator.view.allMonsters

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import cl.desafiolatam.monstercreator.R

import kotlinx.android.synthetic.main.activity_main.*

/*
[] 1. Tu primera tarea es revisar el código facilitado:
     [] Revisar las clases, métodos, layouts etc.
     [X] Verificar si el proyecto puedes ejecutarlo en tu máquina
     [] resolver los posibles problemas de compatibilidad
     [X] descargar las versiones más nuevas de las librerías utilizadas

[] Crear el adaptador para el RecyclerView que mostrará todos los monstruos
    [] Utiliza las vistas ya existentes para los items
    [] implementarlo en MainActivity
    [] recibir los datos en el recyclerView que los mostrara
    [] añadir el RecyclerView en “content_main.xml”

[] 3. construir un repositorio que se encargue de comunicarse con las distintas fuentes de datos
      [] completa el código que haga falta en la clase “MonsterRepository”
      [] revisar si tu DAO está correctamente configurado
      [] Crear una interface para manejar los métodos que utilizaremos
      [] Implementar la interface en la clase repositorio que servirá como puente hacia este desde el viewModel

[] 4. Crea ViewModel que se encargará de manejar los datos provenientes del Repositorio en la vista
      [] modifica el código en la clase AllMonsterViewModel

[] 5. Añadir el viewModel desde el cual nuestra MainActivity consumirá los datos
     [] Realizar las configuraciones
     [] escribir el código necesario para observar los datos utilizando LiveData
     [] pasar los datos observados al adaptador

[] 6. Utiliza el boton del menu superior, para eliminar todos los datos
      [] cambiale el nombre que viene por defecto(“settings”) a (“borrar todos”)

 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}