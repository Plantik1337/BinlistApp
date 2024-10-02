package com.example.binlistapp.domain

import com.example.binlistapp.data.network.CardResponse

interface SearchInteractor {
    suspend fun doRequest(binCode: String): CardResponse?
    fun writeToHistory(cardResponse: CardResponse, cardBin: String)
}