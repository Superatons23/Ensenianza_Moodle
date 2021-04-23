package apps.moviles.enseanza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pantalla_tarea.*

class PantallaTarea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_tarea)
        btnGeografia.setOnClickListener(){
            var intent= Intent(this, PantallaEntregarAsignacion::class.java)
            startActivity(intent)
        }
        btnpantallaPrincipal.setOnClickListener(){
            var intent= Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
    }
}