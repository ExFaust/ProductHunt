package com.somename.data.сontent

import com.google.gson.annotations.SerializedName

class RootTopicsEntity {

    @SerializedName("topics")
    var topics: List<TopicsEntity>? = null
}
