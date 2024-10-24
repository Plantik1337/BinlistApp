package com.example.binlistapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_table")
data class CardInfoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val country: String,
    val cardType: String,
    val locate: String,
    val bank: String,
    val bankUrl: String,
    val phoneNumber: String,
    val city: String,
    val binCode: String
)