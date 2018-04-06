package com.somename.producthunt.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public final class RequestProvider {

    private static DefaultRequestInterface sRequest;

    private RequestProvider() {
    }

    @NonNull
    public static DefaultRequestInterface provideRequest() {
        if (sRequest == null) {
            sRequest = new DefaultRequest();
        }
        return sRequest;
    }

    @MainThread
    public static void init() {
        sRequest = new DefaultRequest();
    }
}
