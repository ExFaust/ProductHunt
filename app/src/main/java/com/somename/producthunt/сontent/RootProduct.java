package com.somename.producthunt.сontent;

import com.google.gson.annotations.SerializedName;

public class RootProduct {

    @SerializedName("post")
    private Product product;

    public Product getProduct ()
    {
        return product;
    }

    public void setProduct (Product product)
    {
        this.product = product;
    }
}
