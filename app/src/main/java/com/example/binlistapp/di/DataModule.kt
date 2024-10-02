package com.example.binlistapp.di

import androidx.room.Room
import com.example.binlistapp.data.Convertor
import com.example.binlistapp.data.SearchRepositoryImpl
import com.example.binlistapp.data.db.AppDatabase
import com.example.binlistapp.data.network.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    factory<Convertor> { Convertor() }

    factory { RetrofitClient }

    factory {
        SearchRepositoryImpl(
            appDatabase = get(),
            convertor = get(),
            retrofit = get()
        )
    }

    single {
        Room.databaseBuilder(
            androidContext(), AppDatabase::class.java, "database.db"
        ).fallbackToDestructiveMigration().build()
    }

}