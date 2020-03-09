package com.csci448.ebergo.scavenger2.ui.ui.keyword_list

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class KeywordListViewModelFactory(private val context:Context): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass:Class<T>):T{
        return modelClass.getConstructor().newInstance()
    }
}