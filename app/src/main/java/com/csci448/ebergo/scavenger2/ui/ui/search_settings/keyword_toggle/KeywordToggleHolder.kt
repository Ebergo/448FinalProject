package com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle

import android.view.View
import android.widget.Switch
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Keyword

class KeywordToggleHolder(val view: View):RecyclerView.ViewHolder(view) {
    private lateinit var keyword: Keyword
    private val titleTextView:Switch = itemView.findViewById(R.id.keyword_toggle)
    fun bind(keyword:Keyword){
        this.keyword = keyword
        titleTextView.text = this.keyword.word
    }
}