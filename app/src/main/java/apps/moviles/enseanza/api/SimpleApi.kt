package apps.moviles.enseanza.api

import apps.moviles.enseanza.model.AuthUser
import apps.moviles.enseanza.model.Post
import apps.moviles.enseanza.model.getAlumno
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

    @GET("/webservice/rest/server.php")
    fun  getAlumno(@Query ("wstoken") wstoken:String="df4353e926da3f515f1d35a05f48d6a1",
                  @Query("wsfunction") wsfunction:String="core_user_get_users_by_field",
                  @Query("moodlewsrestformat") moodlewsrestformat:String="json",
                   @Query("field") username:String="username",
                   @Query("values[]") usaurio: String?): Call<List<getAlumno>>
}