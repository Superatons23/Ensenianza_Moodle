package AccesoDatos

import android.app.VoiceInteractor
import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import apps.moviles.enseanza.MainViewModel
import apps.moviles.enseanza.MainViewModelFactory
import apps.moviles.enseanza.model.AuthUser
import apps.moviles.enseanza.repository.Repository
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Invocation.of
import retrofit2.Response
import java.security.acl.Owner
import java.util.EnumSet.of

class AccesoDatosTutor {

    fun iniciarSesion(usuario:String?,password:String?): String ?{
        println("acceso datos tutor")
        var token: String = "";

        val repository = Repository();
        var call: Call<AuthUser>;
        call = repository.authUser();
        call.enqueue(object :Callback<AuthUser?>{
            override fun onResponse(call: Call<AuthUser?>, response: Response<AuthUser?>) {
                if (response.isSuccessful()){
                    token= response.body()?.token.toString();
                    println(token)
                }
            }

            override fun onFailure(call: Call<AuthUser?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        println(token)
        return token;
    }

    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}