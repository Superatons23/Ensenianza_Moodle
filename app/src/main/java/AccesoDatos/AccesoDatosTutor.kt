package AccesoDatos

import android.content.Context
import android.widget.Toast
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
        var token: String = "asdasdadasdasdasd";
        println("usuario")
        println(usuario)
        println("password")
        println(password)
        var scode: String;

        var url: String =
            "https://cuervos.moodlecloud.com/login/token.php?username=$usuario&password=$password&service=moodle_mobile_app";


        println("url");
        println(url);
        val queue = Volley.newRequestQueue(context)
        val countDownLatch = CountDownLatch(1)
        val responseHolder = arrayOfNulls<Any>(1)

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response ->
                responseHolder[0] = response
                token="si jalo"
                countDownLatch.countDown()

            },
            Response.ErrorListener { error ->
                responseHolder[0] = error
                countDownLatch.countDown()
            })
        queue.add(stringRequest)
        try {
            countDownLatch.await()
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        if (responseHolder[0] is VolleyError) {
            val volleyError = responseHolder[0] as VolleyError?
            scode = volleyError!!.message.toString()
        } else {
            val response = (responseHolder[0] as String?)!!
            if (response === "") scode = "Sin respuesta" else scode = response
        }
        println(token);
        Toast.makeText(context, token, Toast.LENGTH_LONG).show()
        return token;
    }

    private suspend fun request(context: Context?, link: String): String {
        return suspendCancellableCoroutine { continuation ->
            val queue = Volley.newRequestQueue(context)
            val stringRequest = StringRequest(Request.Method.GET, link,
                { response ->
                    continuation.resumeWith(Result.success(response))
                },
                {
                    continuation.cancel(Exception("Volley Error"))
                })

            stringRequest;
        }
    }

    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}