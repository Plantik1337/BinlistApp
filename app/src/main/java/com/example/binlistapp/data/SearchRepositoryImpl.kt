package com.example.binlistapp.data

import android.util.Log
import com.example.binlistapp.data.db.AppDatabase
import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.data.network.RetrofitClient

class SearchRepositoryImpl(
    private val retrofit: RetrofitClient,
    private val appDatabase: AppDatabase,
    private val convertor: Convertor
) : SearchRepository {
    override suspend fun doRequest(cardBin: String): CardResponse? {
        return try {
            retrofit.api.getCardInfo(cardBin)
        } catch (e: Exception) {
            Log.e("BIN_INFO", "Ошибка: ${e.message}")
            null
        }
    }

    override suspend fun writeToHistory(cardResponse: CardResponse, binCode: String) {
        appDatabase.cardDao().insertCard(convertor.map(cardResponse, binCode))
    }
}