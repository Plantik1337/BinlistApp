package com.example.binlistapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [CardInfoEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardDao(): CardDao
}