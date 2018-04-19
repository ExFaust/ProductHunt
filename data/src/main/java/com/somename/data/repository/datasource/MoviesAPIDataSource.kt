package com.somename.data.repository.datasource

import com.somename.data.network.LocalApi
import com.somename.data.сontent.RootEntity
import com.somename.data.сontent.RootProductEntity
import com.somename.data.сontent.RootTopicsEntity

import io.reactivex.Observable

class MoviesAPIDataSource(private val mLocalApi: LocalApi) : DataSource {


    override val techCategoryEntity: Observable<RootEntity>
        get() = mLocalApi.techCategory

    override val trendingTopicsEntity: Observable<RootTopicsEntity>
        get() = mLocalApi.trendingTopics

    override fun getChoosenTopicEntity(topicId: Int): Observable<RootEntity> {
        return mLocalApi.getChosenTopic(topicId)
    }

    override fun getProductEntity(id: String): Observable<RootProductEntity> {
        return mLocalApi.getProduct(id)
    }
}
