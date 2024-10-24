package com.example.binlistapp.data.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BinListApi {
    @GET("{binNumber}")
    suspend fun getCardInfo(
        @Path("binNumber") binNumber: String,
        @Header("Accept-Version") version: String = "3"
    ): CardResponse
}