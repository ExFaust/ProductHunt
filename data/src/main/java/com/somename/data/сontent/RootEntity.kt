package com.somename.data.сontent

import com.google.gson.annotations.SerializedName

class RootEntity {
    @SerializedName("posts")
    var post: List<PostEntity>? = null

}
