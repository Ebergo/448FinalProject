package com.csci448.ebergo.scavenger2.ui.ui.listing_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Listing

class ListingListAdapter(private val listings:List<Listing>,private val clickListener:(Listing) -> Unit): RecyclerView.Adapter<ListingListHolder>() {
    override fun getItemCount(): Int {
        return listings.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ListingListHolder(view)
    }

    override fun onBindViewHolder(holder: ListingListHolder, position: Int) {
        val listing = listings[position]
        holder.bind(listing,clickListener)
    }
}