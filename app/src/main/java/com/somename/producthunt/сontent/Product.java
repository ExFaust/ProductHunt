package com.somename.producthunt.сontent;


import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private String id;

    @SerializedName("screenshot_url")
    private ScreenshotUrl screenshotUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("votes_count")
    private String votesCount;

    @SerializedName("redirect_url")
    private String redirectUrl;

    @SerializedName("tagline")
    private String tagline;

    public ScreenshotUrl getScreenshotUrl() {
        return screenshotUrl;
    }

    public void setScreenshotUrl(ScreenshotUrl screenshotUrl) {
        this.screenshotUrl = screenshotUrl;
    }

    public String getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(String votesCount) {
        this.votesCount = votesCount;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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
