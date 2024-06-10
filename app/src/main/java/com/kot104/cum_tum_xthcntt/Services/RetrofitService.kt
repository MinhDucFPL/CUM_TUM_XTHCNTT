package com.kot104.cum_tum_xthcntt.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.7:3000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}