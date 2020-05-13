package app.web.drjackycv.data.repos.remote

import app.web.drjackycv.data.repos.entity.ItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposApi {

    @GET("repos")
    fun getRepos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 7
    ): Call<List<ItemResponse>>

}