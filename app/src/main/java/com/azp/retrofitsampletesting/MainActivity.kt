package com.azp.retrofitsampletesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.azp.retrofitsampletesting.api.ApiInterface
import com.azp.retrofitsampletesting.model.LatesetResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://forex.cbm.gov.mm/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUser()

    }

    fun getUser(){

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(ApiInterface::class.java)

        var apiCall = retrofitService.getLatest()

        apiCall.enqueue(object : Callback<LatesetResult>{
            override fun onFailure(call: Call<LatesetResult>, t: Throwable) {

            }

            override fun onResponse(call: Call<LatesetResult>, response: Response<LatesetResult>) {
                var latestResult = response.body()

                textLatest.text = response.body().toString()

                Toast.makeText(this@MainActivity, response.body().toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}
