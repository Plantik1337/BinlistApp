package com.example.binlistapp.data

import com.example.binlistapp.data.network.CardResponse

interface SearchRepository {
    suspend fun doRequest(cardBin: String): CardResponse?
    suspend fun writeToHistory(cardResponse: CardResponse, binCode: String)
}