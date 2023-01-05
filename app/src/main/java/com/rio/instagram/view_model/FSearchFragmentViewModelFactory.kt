package com.rio.instagram.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FSearchFragmentViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchFragmentViewModel::class.java))
            return SearchFragmentViewModel(application) as T
        throw IllegalArgumentException("Illegal argument")
    }
}