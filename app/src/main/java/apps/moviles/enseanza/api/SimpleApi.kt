package apps.moviles.enseanza.api

import apps.moviles.enseanza.model.AuthUser
import apps.moviles.enseanza.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("todos/1")
    suspend fun getPost(): Response<Post>

    @GET("/login/token.php?username=estudiante_jesus&password=jesus123&service=moodle_mobile_app")
     fun  authUser(): Call<AuthUser>
}