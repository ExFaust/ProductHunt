package com.somename.data.сontent;

import com.google.gson.annotations.SerializedName;

public class RootProductEntity {

    @SerializedName("post")
    private ProductEntity product;

    public ProductEntity getProduct ()
    {
        return product;
    }

    public void setProduct (ProductEntity product)
    {
        this.product = product;
    }
}
