package apps.moviles.enseanza.api

import apps.moviles.enseanza.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("todos/1")
    suspend fun getPost(): Response<Post>
}