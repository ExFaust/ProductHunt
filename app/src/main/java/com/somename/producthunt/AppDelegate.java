package com.somename.producthunt;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.somename.producthunt.api.ApiFactory;
import com.somename.producthunt.repository.RequestProvider;

public class AppDelegate extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        ApiFactory.recreate();
        RequestProvider.init();
    }

    @NonNull
    public static Context getContext() {
        return sContext;
    }
}
