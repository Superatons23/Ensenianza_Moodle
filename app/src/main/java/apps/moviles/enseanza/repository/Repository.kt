package apps.moviles.enseanza.repository

import apps.moviles.enseanza.api.RetrofitInstance
import apps.moviles.enseanza.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}