package com.example.binlistapp.data

import com.example.binlistapp.data.db.AppDatabase
import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.data.network.RequestState
import com.example.binlistapp.data.network.RetrofitClient

class SearchRepositoryImpl(
    private val retrofit: RetrofitClient,
    private val appDatabase: AppDatabase,
    private val convertor: Convertor
) : SearchRepository {
    override suspend fun doRequest(cardBin: String): RequestState {

        return try {
            RequestState.SuccessRequest(retrofit.api.getCardInfo(cardBin))
        }catch (e:Exception){
            RequestState.Error(e.toString())
        }
    }

    override suspend fun writeToHistory(cardResponse: CardResponse, binCode: String) {
        appDatabase.cardDao().insertCard(convertor.map(cardResponse, binCode))
    }
}