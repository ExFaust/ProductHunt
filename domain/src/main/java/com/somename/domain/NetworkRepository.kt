package com.somename.domain


import com.somename.domain.model.Root
import com.somename.domain.model.RootProduct
import com.somename.domain.model.RootTopics

import io.reactivex.Observable

interface NetworkRepository {

    val techCategory: Observable<Root>

    val trendingTopics: Observable<RootTopics>

    fun getChosenTopic(topicId: Int): Observable<Root>

    fun getProduct(id: String): Observable<RootProduct>

}
