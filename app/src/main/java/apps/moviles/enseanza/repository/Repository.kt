package apps.moviles.enseanza.repository

import apps.moviles.enseanza.api.RetrofitInstance
import apps.moviles.enseanza.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    fun authUser(usuario:String?,password:String?): Call<AuthUser> {
        return RetrofitInstance.apiAuth.authUser(usuario,password);
    }
    fun getAlumno(usuario:String?): Call<List<getAlumno>> {
        return RetrofitInstance.getAlumno.getAlumno(usaurio = usuario);
    }
    fun getCursos(userid:Int?): Call<List<getCursos>> {
        return RetrofitInstance.getAlumno.getCursos(userid = userid);
    }
    fun getParcial(courseid:Int?): Call<List<Parcial>> {
        return RetrofitInstance.getAlumno.getParciales(courseid = courseid);
    }
}