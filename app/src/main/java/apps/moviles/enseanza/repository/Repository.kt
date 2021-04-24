package apps.moviles.enseanza.repository

import apps.moviles.enseanza.api.RetrofitInstance
import apps.moviles.enseanza.model.AuthUser
import apps.moviles.enseanza.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    fun authUser(): Call<AuthUser> {
        return RetrofitInstance.apiAuth.authUser();
    }
}