package com.csci448.ebergo.scavenger2.ui.ui.search_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchSettingsViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}