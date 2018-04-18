package com.somename.data.сontent;

import com.google.gson.annotations.SerializedName;

public class ThumbnailEntity
{
    @SerializedName("id")
    private String id;

    @SerializedName("image_url")
    private String imageUrl;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
