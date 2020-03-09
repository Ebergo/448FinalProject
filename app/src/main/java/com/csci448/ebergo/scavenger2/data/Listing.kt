package com.csci448.ebergo.scavenger2.data

import com.google.android.gms.maps.model.LatLng
import java.util.*

data class Listing ( val id:UUID = UUID.randomUUID(),
               var title: String = "listing title",
               var description: String? = "description",
               var location: LatLng = LatLng(0.0,0.0), //location of item in latitude and longitude coords
               var cost: Float = 0f, //cost of item
               var service: String? = "your mom inc.", //name of website/service e.g. craigslist
               var favorite: Boolean = false,
               var imageUrls: List<String> = emptyList()) //list of all image URLs