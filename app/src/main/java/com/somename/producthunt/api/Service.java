package com.somename.producthunt.api;

import com.somename.producthunt.сontent.Root;
import com.somename.producthunt.сontent.RootProduct;
import com.somename.producthunt.сontent.RootTopics;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface Service {

    @GET("posts/all?access_token=591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff&search[category]=tech&per_page=10")
    Observable<Root> tech();

    @GET("topics?search[trending]=true&access_token=591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff&per_page=10")
    Observable<RootTopics> trending_topics();

    @GET("posts/all?access_token=591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff&per_page=10")
    Observable<Root> choosen_topic(@Query("search[topic]") int topicId);

    @GET("posts/{id}?access_token=591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff")
    Observable<RootProduct> product(@Path("id") String id);

}