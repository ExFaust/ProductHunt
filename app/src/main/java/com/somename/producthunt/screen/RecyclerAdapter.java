package com.somename.producthunt.screen;


import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.somename.producthunt.R;
import com.somename.producthunt.сontent.Post;

import java.util.List;

public class RecyclerAdapter extends BaseAdapter<RecyclerHolder,Post> {

    public RecyclerAdapter(@NonNull List<Post> items) {
        super(items);
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Post post = getItem(position);
        holder.bind(post);
    }

}
