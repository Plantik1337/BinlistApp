package com.example.binlistapp.data

import com.example.binlistapp.data.db.CardInfoEntity
import com.example.binlistapp.data.network.CardResponse

class convertor {
    fun map(cardResponse: CardResponse, binCode: String): CardInfoEntity{
        return CardInfoEntity(
            id = 0,
            country = cardResponse.country.name.toString(),
            locate = cardResponse.country.latitude.toString() + cardResponse.country.longitude.toString(),
            bank = cardResponse.bank.name.toString(),
            bankUrl = cardResponse.bank.url.toString(),
            phoneNumber = cardResponse.bank.phone.toString(),
            city = cardResponse.bank.city.toString(),
            binCode = binCode
        )
    }
}