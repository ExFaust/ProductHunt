package com.somename.producthunt.сontent;


public class PostViewModel
{

    private String votesCount;

    private String tagline;

    private ThumbnailViewModel thumbnailViewModel;

    private String name;

    private String id;


    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public ThumbnailViewModel getThumbnailViewModel()
    {
        return thumbnailViewModel;
    }

    public void setThumbnailViewModel(ThumbnailViewModel thumbnailViewModel)
    {
        this.thumbnailViewModel = thumbnailViewModel;
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
