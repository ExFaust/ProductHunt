package com.somename.data.сontent


import com.google.gson.annotations.SerializedName

class PostEntity {

    @SerializedName("votes_count")
    var votesCount: String? = null

    @SerializedName("tagline")
    var tagline: String? = null

    @SerializedName("thumbnail")
    var thumbnail: ThumbnailEntity? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: String? = null
}
