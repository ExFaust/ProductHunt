package com.somename.producthunt.сontent;


public class ProductViewModel {

    private String id;

    private ScreenshotUrlViewModel screenshotUrlViewModel;

    private String name;

    private String votesCount;

    private String redirectUrl;

    private String tagline;

    public ScreenshotUrlViewModel getScreenshotUrlViewModel() {
        return screenshotUrlViewModel;
    }

    public void setScreenshotUrlViewModel(ScreenshotUrlViewModel screenshotUrlViewModel) {
        this.screenshotUrlViewModel = screenshotUrlViewModel;
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
