package apps.moviles.enseanza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pantalla_login.*
import kotlinx.android.synthetic.main.activity_pantalla_login.btnRegistro
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import kotlinx.android.synthetic.main.activity_pantalla_registrate.*

class PantallaRegistrate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_registrate)
        btnRegistrate.setOnClickListener(){
            startActivity(Intent(this, PantallaRecordarUsuario::class.java))
        }
    }

}