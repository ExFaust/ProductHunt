package com.somename.producthunt.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class TopicRequestProvider {

    private static TopicRequestInterface sRequest;

    private TopicRequestProvider() {
    }

    @NonNull
    public static TopicRequestInterface provideRequest() {
        if (sRequest == null) {
            sRequest = new TopicRequest();
        }
        return sRequest;
    }

    @MainThread
    public static void init() {
        sRequest = new TopicRequest();
    }
}
