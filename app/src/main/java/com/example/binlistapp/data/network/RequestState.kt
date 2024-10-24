package com.example.binlistapp.data.network

sealed class RequestState {
    class SuccessRequest(val cardResponse: CardResponse): RequestState()
    class Error(val errorMessage: String): RequestState()
}