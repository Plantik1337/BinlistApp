package com.example.binlistapp

import android.app.Application
import com.example.binlistapp.di.dataModule
import com.example.binlistapp.di.repositoryModule
import com.example.binlistapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@App)
            androidLogger(Level.NONE)
            modules(listOf(dataModule, repositoryModule, viewModelModule))
        }
    }
}