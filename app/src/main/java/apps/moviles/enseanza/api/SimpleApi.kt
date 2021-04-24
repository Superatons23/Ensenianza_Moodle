package apps.moviles.enseanza.api

import apps.moviles.enseanza.model.AuthUser
import apps.moviles.enseanza.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {
    @GET("todos/1")
    suspend fun getPost(): Response<Post>

    @GET("/login/token.php")
     fun  authUser(@Query ("username") usaurio:String?,
                   @Query("password") password:String?,
                   @Query("service") service:String="moodle_mobile_app",): Call<AuthUser>
}