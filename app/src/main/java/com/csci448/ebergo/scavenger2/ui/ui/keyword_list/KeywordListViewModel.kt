package com.csci448.ebergo.scavenger2.ui.ui.keyword_list

import androidx.lifecycle.ViewModel
import com.csci448.ebergo.scavenger2.data.AggKeywordListing

class KeywordListViewModel():ViewModel() {
    val dummyAggListings:MutableList<AggKeywordListing> = mutableListOf()
    init{
        dummyAggListings.add(AggKeywordListing())
        dummyAggListings.add(AggKeywordListing("toy",1))
    }
}