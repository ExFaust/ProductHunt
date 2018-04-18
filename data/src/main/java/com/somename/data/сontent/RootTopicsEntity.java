package com.somename.data.сontent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootTopicsEntity {

    @SerializedName("topics")
    private List<TopicsEntity> topics;

    public List<TopicsEntity> getTopics()
    {
        return topics;
    }

    public void setTopics(List<TopicsEntity> topics)
    {
        this.topics = topics;
    }
}
