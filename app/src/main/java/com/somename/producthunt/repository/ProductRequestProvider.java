package com.somename.producthunt.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class ProductRequestProvider {

    private static ProductRequestInterface sRequest;

    private ProductRequestProvider() {
    }

    @NonNull
    public static ProductRequestInterface provideRequest() {
        if (sRequest == null) {
            sRequest = new ProductRequest();
        }
        return sRequest;
    }

    @MainThread
    public static void init() {
        sRequest = new ProductRequest();
    }
}
