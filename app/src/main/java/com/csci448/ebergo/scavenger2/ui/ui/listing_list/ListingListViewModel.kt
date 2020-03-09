package com.csci448.ebergo.scavenger2.ui.ui.listing_list

import androidx.lifecycle.ViewModel
import com.csci448.ebergo.scavenger2.data.Listing

class ListingListViewModel(): ViewModel() {
    val listings:MutableList<Listing> = mutableListOf()
    init{
        listings.add(Listing(title="test"))
        listings.add(Listing(title="test2"))
        listings.add(Listing(title="table"))
    }
    //TODO repository for listings
}