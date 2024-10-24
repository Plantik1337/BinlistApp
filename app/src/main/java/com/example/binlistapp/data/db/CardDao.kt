package com.example.binlistapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
//    @Insert(entity = CardInfoEntity::class, onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertCard(cardInfoEntity: CardInfoEntity)
//
////    @Query("SELECT * FROM CARD_TABLE ORDER BY id DESC")
////    suspend fun getCardsList(): List<CardInfoEntity>
//
//    @Query("DELETE FROM CARD_TABLE WHERE id = :cardId")
//    suspend fun deleteById(cardId: Int)
//
//    @Query("DELETE FROM card_table")
//    suspend fun deleteAll()
}