package com.somename.producthunt.сontent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root
{
    @SerializedName("posts")
    private List<Post> post;

    public List<Post> getPost()
    {
        return post;
    }

    public void setPost(List<Post> post)
    {
        this.post = post;
    }

}
