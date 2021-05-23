package apps.moviles.enseanza

import Dominio.Clase
import Dominio.Curso
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
import kotlin.collections.ArrayList


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


              //
                if (alumno != null) {
                    //validar que sea mtro o estudiante
                    val list = alumno.userName?.split("_")
                    var intent: Intent? =null

                    //estudiante
                    if(list?.get(0).equals("estudiante")){
                        var cursos=fachadaNegocio.obtenerCursos(this,alumno?.id) as ArrayList<Clase>
                         intent = Intent(this,PantallaPrincipal::class.java)
                        intent.putExtra("alumno",alumno)
                        intent.putParcelableArrayListExtra("cursos",cursos)
                    //maestro
                    }else if(list?.get(0).equals("maestro")){

                        //obtener cursos que imparte el maistro

                        var cursosMtro=fachadaNegocio.obtenerCursosMtro(this,alumno?.id) as ArrayList<Curso>;

                        intent = Intent(this,PantallaPrincipalMaestro::class.java)

                        //set cursos a la siguiente activity
                        intent.putExtra("alumno",alumno)
                        intent.putParcelableArrayListExtra("cursos",cursosMtro)


                    }


                    this.startActivity(intent)
                    this.isRunning=false;

                }


            } else {
                this.isRunning=false;
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


}