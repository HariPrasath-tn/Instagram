package com.rio.instagram.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FHomeFragmentViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeFragmentViewModel::class.java))
            return HomeFragmentViewModel(application) as T
        throw IllegalArgumentException("Illegal argument")
    }
}