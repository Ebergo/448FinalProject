package com.csci448.ebergo.scavenger2.ui.ui.search_settings.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LocationViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}