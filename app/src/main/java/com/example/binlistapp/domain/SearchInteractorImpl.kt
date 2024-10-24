package com.example.binlistapp.domain

import com.example.binlistapp.data.SearchRepository
import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.data.network.RequestState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchInteractorImpl(
    private val repository: SearchRepository
) : SearchInteractor {

    override fun writeToHistory(cardResponse: CardResponse, cardBin: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.writeToHistory(cardResponse, cardBin)
        }
    }

    override suspend fun doRequest(binCode: String): RequestState {
//        val response = repository.doRequest(binCode)
//        if (response != null) {
//            writeToHistory(response, binCode)
//        }
//        return response
        //val response = repository.doRequest(binCode)
        return repository.doRequest(binCode)
    }
}