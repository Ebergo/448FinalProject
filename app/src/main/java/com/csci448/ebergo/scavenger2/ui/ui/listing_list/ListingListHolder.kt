package com.csci448.ebergo.scavenger2.ui.ui.listing_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Listing
import kotlinx.android.synthetic.main.list_item.view.*

class ListingListHolder(val view: View): RecyclerView.ViewHolder(view) {
    private lateinit var listing:Listing
    private val listingTitle: TextView = itemView.findViewById(R.id.item_title)
    private val listingPrice: TextView = itemView.findViewById(R.id.item_price)
    private val listingLocation: TextView = itemView.findViewById(R.id.item_location)
    private val listingService: TextView = itemView.findViewById(R.id.item_service)
    private val listingImage: ImageView = itemView.findViewById(R.id.thumb_image)
    private val listingServiceImage:ImageView = itemView.findViewById(R.id.service_logo)
    private val listingFavorite:ImageView = itemView.findViewById(R.id.favorite_imageview)
    fun bind(listing: Listing,clickListener:(Listing)->Unit){
        this.listing = listing
        itemView.setOnClickListener{
            clickListener(this.listing)
        }
        listingTitle.text = this.listing.title
        listingPrice.text = this.listing.cost.toString()
        listingLocation.text = this.listing.location.toString()
        listingService.text = this.listing.service
        //TODO set image url for service and thumbnail

    }
}