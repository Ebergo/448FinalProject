package com.csci448.ebergo.scavenger2.ui.ui.detail_listing

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailListingViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}