package com.somename.data.repository.datasource

import com.somename.data.сontent.RootEntity
import com.somename.data.сontent.RootProductEntity
import com.somename.data.сontent.RootTopicsEntity

import io.reactivex.Observable

interface DataSource {

    val techCategoryEntity: Observable<RootEntity>

    val trendingTopicsEntity: Observable<RootTopicsEntity>

    fun getChosenTopicEntity(topicId: Int): Observable<RootEntity>

    fun getProductEntity(id: String): Observable<RootProductEntity>

}
