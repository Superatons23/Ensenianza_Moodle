package apps.moviles.enseanza

import Dominio.Clase
import Dominio.Tarea
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pantalla_clase_detalle.*
import java.lang.Exception
import java.util.*

class PantallaClaseDetalle : AppCompatActivity() {
    lateinit var clase:Clase
    lateinit var actividades:ArrayList<Tarea>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_clase_detalle);
        var bundle=intent.extras
        if(bundle!=null) {
            clase=bundle.get("clase") as Clase
            et_nombreClase.text=clase.nombreClase
            et_descripcion.text=clase.nombreProfesor

        }
        actividades= ArrayList<Tarea>()
        cargarTareas()

        tareaUrgenteBttn.setOnClickListener(){
            try {
            var intent= Intent(this, PantallaEntregarAsignacion::class.java)
            intent.putExtra("clase",clase)
            intent.putExtra("tarea",actividades[0])
            startActivity(intent)
            }catch(e:Exception) {
                Toast.makeText(this,"No existe esa tarea",Toast.LENGTH_SHORT).show()
            }
        }
        tareaNormalBttn.setOnClickListener(){
            try {
            var intent= Intent(this, PantallaEntregarAsignacion::class.java)
            intent.putExtra("clase",clase)
            intent.putExtra("tarea",actividades[1])
            startActivity(intent)
        }catch(e:Exception) {
            Toast.makeText(this,"No existe esa tarea",Toast.LENGTH_SHORT).show()
        }
        }
        tareaBttn.setOnClickListener(){
            try {
                var intent= Intent(this, PantallaEntregarAsignacion::class.java)
                intent.putExtra("clase",clase)
                intent.putExtra("tarea",actividades[2])
                startActivity(intent)
            }catch(e:Exception) {
                Toast.makeText(this,"No existe esa tarea",Toast.LENGTH_SHORT).show()
            }

        }
        bttnClasesGrabadas.setOnClickListener(){
            startActivity(Intent(this, PantallaClasesGrabadas::class.java))

        }
        bttnAsesoria.setOnClickListener(){
            startActivity(Intent(this, PantallaTutoriales::class.java))

        }
        btnChat.setOnClickListener(){
            startActivity(Intent(this, PantallaMensajes::class.java))

        }
    }


    fun cargarTareas(){

        for (p in clase.parciales){
            for (a in p.actividades){
                actividades.add(a)
            }
        }

        if(actividades.size>0){
            tareaUrgenteBttn.setText(actividades[0].nombre)
            if(actividades.size>1){
                tareaNormalBttn.setText(actividades[1].nombre)
            }
            if(actividades.size>2){
                tareaBttn.setText(actividades[2].nombre)
            }

        }
    }
}