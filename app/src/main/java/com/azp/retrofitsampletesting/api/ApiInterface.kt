package com.azp.retrofitsampletesting.api

import com.azp.retrofitsampletesting.model.LatesetResult
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("latest")
    fun getLatest(): Call<LatesetResult>

}