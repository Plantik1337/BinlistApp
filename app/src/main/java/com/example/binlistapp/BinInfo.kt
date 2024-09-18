package com.example.binlistapp

data class BinInfo(
    val country: Country?,
    val bank: Bank?,
    // добавь другие поля, которые возвращает API
)

data class Country(
    val name: String?,
    val code: String?
)

data class Bank(
    val name: String?,
    val url: String?,
    val phone: String?
)
