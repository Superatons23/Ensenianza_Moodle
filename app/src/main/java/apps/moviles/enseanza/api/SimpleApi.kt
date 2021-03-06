package apps.moviles.enseanza.api

import apps.moviles.enseanza.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

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

    @GET("/webservice/rest/server.php")
    fun  getCursos(@Query ("wstoken") wstoken:String="df4353e926da3f515f1d35a05f48d6a1",
                   @Query("wsfunction") wsfunction:String="core_enrol_get_users_courses",
                   @Query("moodlewsrestformat") moodlewsrestformat:String="json",
                   @Query("userid") userid:Int?): Call<List<getCursos>>

    @GET("/webservice/rest/server.php")
    fun  getParciales(@Query ("wstoken") wstoken:String="df4353e926da3f515f1d35a05f48d6a1",
                   @Query("wsfunction") wsfunction:String="core_course_get_contents",
                   @Query("moodlewsrestformat") moodlewsrestformat:String="json",
                   @Query("courseid") courseid:Int?): Call<List<Parcial>>

    @GET("/webservice/rest/server.php")
    fun  getMaestros(@Query ("wstoken") wstoken:String="df4353e926da3f515f1d35a05f48d6a1",
                      @Query("wsfunction") wsfunction:String="core_enrol_get_enrolled_users",
                      @Query("moodlewsrestformat") moodlewsrestformat:String="json",
                      @Query("courseid") courseid:Int?): Call<List<getMaestros>>


}