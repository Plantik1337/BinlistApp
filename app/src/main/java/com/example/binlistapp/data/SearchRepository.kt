package com.example.binlistapp.data

import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.data.network.RequestState

interface SearchRepository {
    suspend fun doRequest(cardBin: String): RequestState
    suspend fun writeToHistory(cardResponse: CardResponse, binCode: String)
}