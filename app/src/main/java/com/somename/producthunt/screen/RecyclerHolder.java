package com.somename.producthunt.screen;


import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.somename.producthunt.R;
import com.somename.producthunt.сontent.Post;

public class RecyclerHolder extends RecyclerView.ViewHolder{

    private TextView mName;
    private TextView mTagline;
    private TextView mVotes;
    private ImageView mThumnail;
    private View mItemView;
    private ProgressBar mProgressBar;

    public RecyclerHolder(View itemView) {
        super(itemView);
        this.mItemView = itemView;
        mName = itemView.findViewById(R.id.item_name);
        mTagline = itemView.findViewById(R.id.item_tagline);
        mVotes = itemView.findViewById(R.id.item_votes);
        mThumnail = itemView.findViewById(R.id.item_thumbnail);
        mProgressBar = itemView.findViewById(R.id.item_placeholder);
    }

    public void bind(@NonNull Post post) {
        mName.setText(post.getName());
        mTagline.setText(post.getTagline());
        mVotes.setText(post.getVotesCount());
        String url = post.getThumbnail().getImageUrl();

        Glide
                .with(mItemView)
                .load(url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        mProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(mThumnail);
    }
}
