package apps.moviles.enseanza

import Negocio.FachadaNegocio
import Negocio.Factory
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import apps.moviles.enseanza.repository.Repository
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_pantalla_login.btnRegistro
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.net.URL


class PantallaLogin_2 : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var negocio: FachadaNegocio;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_login_2)



        btnRegistro.setOnClickListener() {
            startActivity(Intent(this, PantallaRegistrate::class.java))
        }


        btnIngresar.setOnClickListener() {
          authUser();

        }


    }











    fun authUser(){
        var contrasenia: String = et_contrasenia.text.toString();
        var user: String? = et_correo.text.toString();

        var url: String =
            "https://cuervos.moodlecloud.com/login/token.php?username=$user&password=$contrasenia&service=moodle_mobile_app";


        var que = Volley.newRequestQueue(this);
        var reques =
            JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                com.android.volley.Response.Listener { response ->

                    if (response.has("token")) startActivity(
                        Intent(
                            this,
                            PantallaPrincipal::class.java
                        )
                    ) else Toast.makeText(
                        this,
                        "Ingresar Credenciales validas",
                        Toast.LENGTH_SHORT
                    ).show();


                },
                com.android.volley.Response.ErrorListener {

                })
        que.add(reques);

    }
}