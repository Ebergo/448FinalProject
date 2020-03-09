package com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle

import androidx.lifecycle.ViewModel
import com.csci448.ebergo.scavenger2.data.Keyword

class KeywordToggleViewModel(): ViewModel() {
    val keywords:MutableList<Keyword> = mutableListOf()
    init{
        keywords.add(Keyword("test"))
        keywords.add(Keyword("test2"))
        keywords.add(Keyword("bob"))
    }
}