package apps.moviles.enseanza

import Dominio.Clase
import Negocio.FachadaNegocio
import Negocio.Factory
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_pantalla_login.btnRegistro
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import java.util.*
import kotlinx.android.synthetic.main.activity_pantalla_login_2.et_contrasenia
import kotlinx.android.synthetic.main.activity_pantalla_login_2.et_correo
import kotlinx.android.synthetic.main.activity_pantalla_registrate.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.net.URL


class PantallaLogin_2 : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var negocio: FachadaNegocio;
    private var isRunning:Boolean=false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_login_2)


        val fachadaNegocio = Factory.crearFachadaNegocio();


        btnRegistro.setOnClickListener() {
            startActivity(Intent(this, PantallaRegistrate::class.java))
        }


        btnIngresar.setOnClickListener() {
            // authUser();
            if(!this.isRunning){
                authUserThread(fachadaNegocio);
                this.isRunning=true;
            }




        }

        btnRegistro.setOnClickListener(){
            startActivity(Intent(this, PantallaRecordarUsuario::class.java))
        }


    }


    fun authUserThread(fachadaNegocio: FachadaNegocio) {

        var hilo = Thread(Runnable {
            var contrasenia: String = et_contrasenia.text.toString();
            var user: String? = et_correo.text.toString();

            var isUser = fachadaNegocio.iniciarSesion(this, user, contrasenia);

            if (isUser == true) {
                println("abriendo pantalla principal")
                var alumno=fachadaNegocio.obtenerAlumno(this,user)
                var cursos=fachadaNegocio.obtenerCursos(this,alumno?.id) as ArrayList<Clase>
                val intent = Intent(this,PantallaPrincipal::class.java)
                if (alumno != null) {
                    intent.putExtra("alumno",alumno)
                    intent.putParcelableArrayListExtra("cursos",cursos)
                    this.startActivity(intent)
                    this.isRunning=false;

                }


            } else {

                @WorkerThread
                fun workerThread() {
                    ContextCompat.getMainExecutor(this).execute {
                        Toast.makeText(
                            this,
                            "Ingresar Credenciales validas",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                }
                workerThread();
            };

        })


            hilo.start();



    }

    fun authUser() {
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