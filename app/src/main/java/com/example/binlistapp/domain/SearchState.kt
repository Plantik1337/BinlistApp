package com.example.binlistapp.domain

import com.example.binlistapp.data.network.CardResponse

sealed class SearchState {
    class Success(val response: CardResponse) : SearchState()
    class Error(val errorMessage: String) : SearchState()
    object Loading : SearchState()
}