package com.csci448.ebergo.scavenger2.ui.ui.keyword_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.AggKeywordListing

class KeywordListAdapter(private val keywords:List<AggKeywordListing>,private val clickListener:(AggKeywordListing) -> Unit): RecyclerView.Adapter<KeywordHolder>() {
    override fun getItemCount(): Int {
        return keywords.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_keyword_listing,parent,false)
        return KeywordHolder(view)
    }

    override fun onBindViewHolder(holder: KeywordHolder, position: Int) {
        val keyword = keywords[position]
        holder.bind(keyword,clickListener)
    }
}