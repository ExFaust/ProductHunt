package com.somename.producthunt.screen.adapters;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.somename.producthunt.R;
import com.somename.producthunt.сontent.PostViewModel;

import java.util.List;

public class RecyclerAdapter extends BaseAdapter<RecyclerHolder,PostViewModel> {

    public RecyclerAdapter(@NonNull List<PostViewModel> items) {
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
        PostViewModel postViewModel = getItem(position);
        holder.bind(postViewModel);
    }

}
