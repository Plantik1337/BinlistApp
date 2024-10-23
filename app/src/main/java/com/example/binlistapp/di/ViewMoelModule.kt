package com.example.binlistapp.di

import com.example.binlistapp.presentation.viewmodels.HistoryViewModel
import com.example.binlistapp.presentation.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SearchViewModel(interactor = get())
    }
    viewModel {
        HistoryViewModel()
    }
}