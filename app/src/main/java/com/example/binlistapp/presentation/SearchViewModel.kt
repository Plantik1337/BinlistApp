package com.example.binlistapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.binlistapp.data.RetrofitClient
import com.example.binlistapp.data.CardResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    var binML = MutableLiveData<CardResponse>()
    fun binLiveData(): LiveData<CardResponse> = binML

    fun doRequest(cardBin: String){
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val binInfo = RetrofitClient.api.getCardInfo(cardBin)
                binML.postValue(binInfo)
                Log.d("BIN_INFO", "Страна: ${binInfo.country?.name}, Банк: ${binInfo.bank?.name}")
                Log.d("BinWholeInfo", binInfo.country.latitude.toString())
            } catch (e: Exception) {
                Log.e("BIN_INFO", "Ошибка: ${e.message}")
            }
        }
    }

    //        lifecycleScope.launch {
//            try {
//                val binInfo = RetrofitClient.api.getCardInfo(binCode)
//                Log.d("BIN_INFO", "Страна: ${binInfo.country?.name}, Банк: ${binInfo.bank?.name}")
//                Log.d("BinWholeInfo", binInfo.country.latitude.toString())
//            } catch (e: HttpException) {
//                Log.e("BIN_INFO", "Ошибка HTTP: ${e.code()}")
//            } catch (e: Exception) {
//                Log.e("BIN_INFO", "Ошибка: ${e.message}")
//            }
//        }
}