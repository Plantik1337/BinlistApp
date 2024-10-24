package com.example.binlistapp.domain

import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.data.network.RequestState

interface SearchInteractor {
    suspend fun doRequest(binCode: String): RequestState
    fun writeToHistory(cardResponse: CardResponse, cardBin: String)
}