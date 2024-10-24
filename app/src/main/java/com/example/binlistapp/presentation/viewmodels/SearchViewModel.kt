package com.example.binlistapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.binlistapp.data.network.RequestState
import com.example.binlistapp.domain.SearchInteractor
import com.example.binlistapp.domain.SearchState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val interactor: SearchInteractor) : ViewModel() {

    private var binML = MutableLiveData<SearchState>()
    fun binLiveData(): LiveData<SearchState> = binML

    fun doRequest(cardBin: String) {
        CoroutineScope(Dispatchers.IO).launch {
            binML.postValue(SearchState.Loading)

            when (val request = interactor.doRequest(cardBin)) {
                is RequestState.SuccessRequest -> binML.postValue(SearchState.Success(request.cardResponse))

                is RequestState.Error -> binML.postValue(SearchState.Error(request.errorMessage))
            }
        }
    }
}