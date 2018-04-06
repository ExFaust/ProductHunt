package com.somename.producthunt.сontent;

import com.google.gson.annotations.SerializedName;

public class ScreenshotUrl {

    @SerializedName("850px")
    private String image850px;

    public String getImage850px() {
        return image850px;
    }

    public void setImage850px(String image850px) {
        this.image850px = image850px;
    }
}
