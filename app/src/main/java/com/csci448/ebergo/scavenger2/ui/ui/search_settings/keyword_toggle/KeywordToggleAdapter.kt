package com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Keyword

class KeywordToggleAdapter(private val keywords:List<Keyword>): RecyclerView.Adapter<KeywordToggleHolder>() {
    override fun getItemCount(): Int {
        return keywords.size
    }

    override fun onBindViewHolder(holder: KeywordToggleHolder, position: Int) {
        val keyword = keywords[position]
        holder.bind(keyword)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordToggleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_keyword_toggle,parent,false)
        return KeywordToggleHolder(view)

    }
}