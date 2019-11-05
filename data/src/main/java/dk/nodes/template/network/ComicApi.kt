package dk.nodes.template.network

import dk.nodes.template.models.dto.ComicsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicApi {
    @GET("comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ComicsResponse>
}