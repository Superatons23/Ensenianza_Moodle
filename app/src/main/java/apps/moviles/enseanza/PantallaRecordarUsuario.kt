package apps.moviles.enseanza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import kotlinx.android.synthetic.main.activity_pantalla_recordar_usuario.*

class PantallaRecordarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_recordar_usuario)

        btnSi.setOnClickListener(){
            startActivity(Intent(this, PantallaPrincipal::class.java))
        }
        btnMasTarde.setOnClickListener(){
            startActivity(Intent(this, PantallaPrincipal::class.java))
        }

    }
}