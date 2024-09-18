package com.example.binlistapp

import com.example.binlistapp.data.BinListApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://lookup.binlist.net/"

    val api: BinListApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  // Конвертер для обработки JSON
            .build()
            .create(BinListApi::class.java)
    }
}