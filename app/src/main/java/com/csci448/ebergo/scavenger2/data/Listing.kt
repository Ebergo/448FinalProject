package com.csci448.ebergo.scavenger2.data

import com.google.android.gms.maps.model.LatLng

class Listing (title: String,
               descrption: String,
               location: LatLng,
               cost: Float,
               vararg imageUrls: String)