package com.somename.producthunt.сontent;


import com.google.gson.annotations.SerializedName;

public class Post
{

    @SerializedName("votes_count")
    private String votesCount;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;


    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Thumbnail getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (Thumbnail thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getVotesCount ()
    {
        return votesCount;
    }

    public void setVotesCount (String votes_count)
    {
        this.votesCount = votes_count;
    }

    public String getTagline ()
    {
        return tagline;
    }

    public void setTagline (String tagline)
    {
        this.tagline = tagline;
    }
}
