package com.example.binlistapp.di

import com.example.binlistapp.domain.SearchInteractor
import com.example.binlistapp.domain.SearchInteractorImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<SearchInteractor> {
        SearchInteractorImpl(repository = get())
    }
}