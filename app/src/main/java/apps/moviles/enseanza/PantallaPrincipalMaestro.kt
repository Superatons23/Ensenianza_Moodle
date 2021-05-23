package apps.moviles.enseanza

import Dominio.Alumno
import Dominio.Clase
import Dominio.Curso
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pantalla_principal_maestro.*
import kotlinx.android.synthetic.main.activity_pantalla_principal_maestro.prin_btn_tareas
import java.util.ArrayList

class PantallaPrincipalMaestro : AppCompatActivity() {

    lateinit var usuario:Alumno
    var cursos = ArrayList<Curso>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal_maestro)

        var bundle=intent.extras
        if(bundle!=null) {

            var alumno: Alumno = bundle.get("alumno") as Alumno
            usuario=alumno
            prin_nombre_mtro.setText("Mtro. "+alumno.nombre + " " + alumno.apellido)
            Picasso.get().load(alumno.foto).into(prin_imagen_perfil_mtro);
            cursos= bundle.get("cursos") as ArrayList<Curso>
        }


        prin_btn_tareas.setOnClickListener {
            var intent = Intent(this, PantallaCursos::class.java)
            intent.putParcelableArrayListExtra("cursos",cursos)

            startActivity(intent)
        }

        prin_btn_mensajes.setOnClickListener {
            var intent = Intent(this, PantallaMensajesMaestro::class.java)
            intent.putExtra("usuario",usuario)
            startActivity(intent)
        }
    }
}