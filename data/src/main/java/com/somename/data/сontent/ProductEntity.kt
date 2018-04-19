package com.somename.data.сontent


import com.google.gson.annotations.SerializedName

class ProductEntity {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("screenshot_url")
    var screenshotUrl: ScreenshotUrlEntity? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("votes_count")
    var votesCount: String? = null

    @SerializedName("redirect_url")
    var redirectUrl: String? = null

    @SerializedName("tagline")
    var tagline: String? = null
}
