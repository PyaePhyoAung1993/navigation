package com.example.movie.api


import com.example.movie.model.TopRated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("top_rated")   //Query stream parameter
    fun getLatestMovie(@Query("api_key")apikey : String): Call<TopRated>

    @GET("MovieID")
    fun detailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Call<TopRated>
}

