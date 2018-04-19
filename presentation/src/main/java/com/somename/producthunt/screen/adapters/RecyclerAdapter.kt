package com.somename.producthunt.screen.adapters


import android.view.LayoutInflater
import android.view.ViewGroup

import com.somename.producthunt.R
import com.somename.producthunt.сontent.PostViewModel

class RecyclerAdapter(items: List<PostViewModel>) : BaseAdapter<RecyclerHolder, PostViewModel>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        return RecyclerHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val postViewModel = getItem(position)
        holder.bind(postViewModel)
    }

}
