package apps.moviles.enseanza

import Negocio.FachadaNegocio
import Negocio.Factory
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import apps.moviles.enseanza.repository.Repository
import kotlinx.android.synthetic.main.activity_pantalla_login.btnRegistro
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.net.URL


class PantallaLogin_2 : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    private lateinit var negocio:FachadaNegocio;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_login_2)

       negocio=Factory.crearFachadaNegocio();

        btnRegistro.setOnClickListener(){
            startActivity(Intent(this, PantallaRegistrate::class.java))
        }


        negocio.iniciarSesion();

    }
}