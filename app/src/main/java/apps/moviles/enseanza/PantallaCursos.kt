package apps.moviles.enseanza

import Dominio.Actividad
import Dominio.Alumno
import Dominio.Curso
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_avalar_tareas.*
import kotlinx.android.synthetic.main.activity_avalar_tareas.gridview_clases_avalar
import kotlinx.android.synthetic.main.activity_pantalla_cursos.*
import kotlinx.android.synthetic.main.activity_pantalla_principal.*
import kotlinx.android.synthetic.main.activity_pantalla_tutorial.view.*
import kotlinx.android.synthetic.main.list_cursos.view.*
import kotlinx.android.synthetic.main.list_tareas_avalar.view.*
import kotlinx.android.synthetic.main.list_tareas_avalar.view.nombre_tarea
import java.util.ArrayList

class PantallaCursos : AppCompatActivity() {

    var adapter: ClasesdapterCursos? = null
    var cursos = ArrayList<Curso>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_cursos)

        var bundle=intent.extras
        if(bundle!=null) {


            cursos= bundle.get("cursos") as ArrayList<Curso>
        }
        adapter=ClasesdapterCursos(this, this.cursos)
        gridview_avalar_cursos.adapter=adapter
    }



    class ClasesdapterCursos: BaseAdapter {
        private var cursos: ArrayList<Curso>
        var contexto: Context? =null
        constructor(contexto: Context, cursos: ArrayList<Curso>){
            this.contexto=contexto
            this.cursos=cursos
        }


        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var actividades=cursos[p0]
            var inflador=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflador.inflate(R.layout.list_cursos, null)
            vista.nombre_curso.setText(actividades.nombre)

            vista.list_btn_curso.setOnClickListener {

                var intent = Intent(contexto, Avalar_tareas::class.java)
                intent.putParcelableArrayListExtra("tareas",cursos.get(p0).parciales)
              contexto!!.startActivity(intent)

            }

            return vista
        }

        override fun getItem(p0: Int): Any {
            return cursos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return cursos.size
        }
    }
}