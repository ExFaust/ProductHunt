package com.somename.data.network


import com.somename.data.сontent.RootEntity
import com.somename.data.сontent.RootProductEntity
import com.somename.data.сontent.RootTopicsEntity
import com.somename.domain.BuildConfig

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocalApi {

    @get:GET("posts/all?" + BuildConfig.API_TOKEN + "&search[category]=tech&per_page=10")
    val techCategory: Observable<RootEntity>

    @get:GET("topics?search[trending]=true&" + BuildConfig.API_TOKEN + "&per_page=10")
    val trendingTopics: Observable<RootTopicsEntity>

    @GET("posts/all?" + BuildConfig.API_TOKEN + "&per_page=10")
    fun getChosenTopic(@Query("search[topic]") topicId: Int): Observable<RootEntity>

    @GET("posts/{id}?" + BuildConfig.API_TOKEN)
    fun getProduct(@Path("id") id: String): Observable<RootProductEntity>
}