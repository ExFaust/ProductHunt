package com.somename.producthunt.сontent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootTopics {

    @SerializedName("topics")
    private List<Topics> topics;

    public List<Topics> getTopics()
    {
        return topics;
    }

    public void setTopics(List<Topics> topics)
    {
        this.topics = topics;
    }
}
