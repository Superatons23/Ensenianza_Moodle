package apps.moviles.enseanza

import Dominio.Actividad
import Dominio.Curso
import Dominio.Parcial
import Dominio.Tarea
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_avalar_tareas.*
import kotlinx.android.synthetic.main.activity_pantalla_clase_grabada.view.*
import kotlinx.android.synthetic.main.activity_pantalla_clases.*
import kotlinx.android.synthetic.main.activity_pantalla_mensajes.*
import kotlinx.android.synthetic.main.activity_pantalla_mensajes.gridview
import kotlinx.android.synthetic.main.list_tareas_avalar.view.*
import java.text.SimpleDateFormat
import java.util.*

class Avalar_tareas : AppCompatActivity() {
    var adapter: ClasesdapterAvalarTarea? = null
    var parciales = ArrayList<Parcial>();
    var tareas = ArrayList<Tarea>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_avalar_tareas)

        var bundle=intent.extras
        if(bundle!=null) {


            parciales= bundle.get("tareas") as ArrayList<Parcial>
            for (i in parciales){
                for (k in i.actividades){
                    tareas.add(Tarea(k.id,k.courseid,k.userid,k.nombre,k.summary));
                }

            }
        }

        adapter=ClasesdapterAvalarTarea(this, this.tareas)
        gridview_clases_avalar.adapter=adapter
    }



}



class ClasesdapterAvalarTarea: BaseAdapter {
    var tareas= ArrayList<Tarea>()
    var contexto: Context? =null
    constructor(contexto: Context, tareas: ArrayList<Tarea>){
        this.contexto=contexto
        this.tareas=tareas
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var tareas=tareas[p0]
        var inflador=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista=inflador.inflate(R.layout.list_tareas_avalar, null)
        vista.nombre_tarea.setText(tareas.nombre)


        return vista
    }

    override fun getItem(p0: Int): Any {
        return tareas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return tareas.size
    }
}