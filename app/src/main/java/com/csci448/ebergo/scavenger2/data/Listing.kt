package com.csci448.ebergo.scavenger2.data

import com.google.android.gms.maps.model.LatLng

class Listing (title: String,
               descrption: String,
               location: LatLng, //location of item in latitude and longitude coords
               cost: Float, //cost of item
               service: String, //name of website/service e.g. craigslist
               vararg imageUrls: String) //list of all image URLs