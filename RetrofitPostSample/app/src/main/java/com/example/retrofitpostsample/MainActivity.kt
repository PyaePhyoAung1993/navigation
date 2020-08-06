package com.example.retrofitpostsample
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitpostsample.api.ApiInterface
import com.example.retrofitpostsample.model.VoteRespones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        voteKing()
    }
    fun voteKing() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService = retrofit.create(ApiInterface::class.java)
        var apiCall = retrofitService.voteKing(
            "gCRDJaeI", "K1"
        )
        apiCall.enqueue(object : Callback<VoteRespones> {
            override fun onFailure(call: Call<VoteRespones>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    t.toString(),
                    Toast.LENGTH_LONG
                ).show()
                Log.d("error", t.toString())
            }
            override fun onResponse(call: Call<VoteRespones>, response: Response<VoteRespones>) {
                Toast.makeText(
                    applicationContext,
                    response.body().toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}