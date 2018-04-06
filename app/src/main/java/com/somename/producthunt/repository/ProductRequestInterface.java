package com.somename.producthunt.repository;

import android.support.annotation.NonNull;
import com.somename.producthunt.сontent.RootProduct;

import rx.Observable;

public interface ProductRequestInterface {
    @NonNull
    Observable<RootProduct> product(String productId);
}
