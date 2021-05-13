package apps.moviles.enseanza

import Dominio.Clase
import Dominio.Tarea
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pantalla_clase_detalle.*
import kotlinx.android.synthetic.main.activity_pantalla_entregar_asignacion.*

class PantallaEntregarAsignacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_entregar_asignacion);
        var bundle=intent.extras
        if(bundle!=null) {
            var clase=bundle.get("clase") as Clase
            var tarea=bundle.get("tarea") as Tarea
            et_titulo.setText(clase.nombreClase)
            et_maestro.setText(clase.nombreProfesor)
            et_asignacion.setText("Asignacion "+ tarea.id)
            et_nombreasignacion.setText(tarea.nombre)
            et_summary.setText(tarea.summary)
        }
    }
}