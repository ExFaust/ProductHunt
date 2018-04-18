package com.somename.data.сontent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootEntity
{
    @SerializedName("posts")
    private List<PostEntity> post;

    public List<PostEntity> getPost()
    {
        return post;
    }

    public void setPost(List<PostEntity> post)
    {
        this.post = post;
    }

}
