package com.csci448.ebergo.scavenger2.data

data class AggKeywordListing(var keyword:String = "keyword",
                             var count:Int = 0,
                             var ImgThumbs:List<String> = emptyList())