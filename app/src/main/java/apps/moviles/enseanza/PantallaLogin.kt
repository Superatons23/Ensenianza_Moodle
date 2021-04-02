package apps.moviles.enseanza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_login.*

class PantallaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_login)


        btnPadres.setOnClickListener(){
            startActivity(Intent(this, PantallaLogin_2::class.java))
        }
        btnProfesor.setOnClickListener(){
            startActivity(Intent(this, PantallaLogin_2::class.java))
        }
        btnRegistro.setOnClickListener(){
            startActivity(Intent(this, PantallaRegistrate::class.java))
        }
    }
}