package com.somename.data.network;


import com.somename.data.BuildConfig;
import com.somename.data.сontent.RootEntity;
import com.somename.data.сontent.RootProductEntity;
import com.somename.data.сontent.RootTopicsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocalApi {

    @GET("posts/all?"+BuildConfig.API_TOKEN+"&search[category]=tech&per_page=10")
    Observable<RootEntity> getTechCategory();

    @GET("topics?search[trending]=true&"+BuildConfig.API_TOKEN+"&per_page=10")
    Observable<RootTopicsEntity> getTrendingTopics();

    @GET("posts/all?"+BuildConfig.API_TOKEN+"&per_page=10")
    Observable<RootEntity> getChosenTopic(@Query("search[topic]") int topicId);

    @GET("posts/{id}?"+BuildConfig.API_TOKEN)
    Observable<RootProductEntity> getProduct(@Path("id") String id);
}