package com.csci448.ebergo.scavenger2.data

import com.google.android.gms.maps.model.LatLng
import java.util.*
@Entity
data class Listing ( @PrimaryKey val id:UUID = UUID.randomUUID()
               var title: String = "listing title",
               var descrption: String? = "description",
               var location: LatLng, //location of item in latitude and longitude coords
               var cost: Float = 0f, //cost of item
               var service: String? = "your mom inc.", //name of website/service e.g. craigslist
               var imageUrls: List<String> = emptyList()) //list of all image URLs