package com.example.retrofitpostsample.api


import com.example.retrofitpostsample.model.voteResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiInterface{
    @POST("Kingvote")
    fun voteking(
            @Query("code")code: String,
            @Query("king_id")kingID:String
    ):Call<voteResponse>
}


