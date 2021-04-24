package AccesoDatos

import android.content.Context
import android.widget.Toast
import apps.moviles.enseanza.repository.Repository
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.CountDownLatch


class AccesoDatosTutor {

    fun iniciarSesion(context: Context?, usuario: String?, password: String?): String? {
        println("acceso datos tutor")
        var token: String = "";
        println("usuario")
        println(usuario)
        println("password")
        println(password)



        var repository = Repository();
        var authUser = repository.authUser(usuario,password)
        token = authUser.execute().body()?.token.toString();



        return token;
    }


    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}