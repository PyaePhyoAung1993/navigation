package com.example.movie.api

import com.example.movie.model.TopRated
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Movieapi {
    companion object{
        const val BASE_URL = " https://api.themoviedb.org/3/movie/"
    }
    private val apiInterface: ApiInterface

    init {

        val  retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }
    fun getTopRate(apiKey: String): Call<TopRated> {
        return apiInterface.getLatestMovie(apiKey)

    }


}



