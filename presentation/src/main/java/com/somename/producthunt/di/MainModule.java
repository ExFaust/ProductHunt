package com.somename.producthunt.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.somename.data.network.LocalApi;
import com.somename.data.network.LoggingInterceptor;
import com.somename.data.repository.MovieNetworkRepository;
import com.somename.domain.NetworkRepository;
import com.somename.producthunt.AppDelegate;
import com.somename.producthunt.BuildConfig;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    private final AppDelegate mAppDelegate;

    public MainModule(AppDelegate appDelegate) {
        this.mAppDelegate = appDelegate;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mAppDelegate;
    }

    @Provides
    @Singleton
    NetworkRepository provideRepository(MovieNetworkRepository movieNetworkRepository) {
        return movieNetworkRepository;
    }

    @Provides
    @Singleton
    LocalApi provideAPI(@NonNull Retrofit retrofit) {
        return retrofit.create(LocalApi.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }

    @Provides @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides @Named("ui_thread") Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
