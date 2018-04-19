package com.somename.producthunt.screen.adapters


import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.somename.producthunt.сontent.PostViewModel
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerHolder(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

    fun bind(postViewModel: PostViewModel) {
        mItemView.itemName.text = postViewModel.name
        mItemView.itemTagline.text = postViewModel.tagline
        mItemView.itemVotes.text = postViewModel.votesCount
        val url = postViewModel.thumbnailViewModel?.imageUrl

        Glide
                .with(mItemView)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        itemView.itemPlaceholder.visibility = View.GONE
                        return false
                    }
                })
                .into(itemView.itemThumbnail)
    }
}
