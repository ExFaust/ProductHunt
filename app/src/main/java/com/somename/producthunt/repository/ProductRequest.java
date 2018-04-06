package com.somename.producthunt.repository;


import android.support.annotation.NonNull;

import com.somename.producthunt.api.ApiFactory;
import com.somename.producthunt.сontent.RootProduct;

import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

public class ProductRequest implements ProductRequestInterface {

    @NonNull
    @Override
    public Observable<RootProduct> product(String productId) {
        return ApiFactory.getService()
                .product(productId)
                .compose(RxUtils.async());
    }
}
