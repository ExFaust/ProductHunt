package com.somename.producthunt;

import android.app.Application;

import com.somename.producthunt.di.DaggerMainComponent;
import com.somename.producthunt.di.MainComponent;
import com.somename.producthunt.di.MainModule;

public class AppDelegate extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();

    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

}
