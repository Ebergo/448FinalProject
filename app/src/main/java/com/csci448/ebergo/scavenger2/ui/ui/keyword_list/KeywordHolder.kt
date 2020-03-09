package com.csci448.ebergo.scavenger2.ui.ui.keyword_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.AggKeywordListing
import kotlinx.android.synthetic.main.fragment_keyword_listing.view.*

class KeywordHolder(val view: View):RecyclerView.ViewHolder(view) {
    private lateinit var keyword:AggKeywordListing
    private val keywordTitle: TextView = itemView.findViewById(R.id.key_word_title)
    private val keywordCount: TextView = itemView.findViewById(R.id.listing_count)
    fun bind(keyword:AggKeywordListing,clickListener:(AggKeywordListing) -> Unit){
        this.keyword = keyword
        itemView.setOnClickListener{clickListener(this.keyword)}
        keywordTitle.text = this.keyword.keyword
        keywordCount.text = this.keyword.count.toString()
        //TODO: add thumbnails to keyword listing thing

    }

}