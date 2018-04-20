package com.somename.data.repository

import com.somename.data.network.LocalApi
import com.somename.data.repository.datasource.APIDataSource
import com.somename.data.сontent.RootEntity
import com.somename.data.сontent.RootProductEntity
import com.somename.data.сontent.RootTopicsEntity

import io.reactivex.Observable

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class APIDataSourceTest {

    @Mock
    private val mLocalApi: LocalApi? = null

    private var mApiDataSource: APIDataSource? = null

    @Before
    fun setUp() {
        mApiDataSource = APIDataSource(mLocalApi!!)
    }

    @Test
    fun givenTrendingTopicsFromLocalApi() {
        mApiDataSource!!.trendingTopicsEntity
        verify<LocalApi>(mLocalApi).trendingTopics
    }

    @Test
    fun givenChosenTopicFromLocalApi() {
        mApiDataSource!!.getChosenTopicEntity(TOPIC_ID)
        verify<LocalApi>(mLocalApi).getChosenTopic(TOPIC_ID)
    }

    @Test
    fun givenProductFromLocalApi() {
        mApiDataSource!!.getProductEntity(PRODUCT_ID)
        verify<LocalApi>(mLocalApi).getProduct(PRODUCT_ID)
    }

    @Test
    fun givenTechCategoryFromLocalApi() {
        mApiDataSource!!.techCategoryEntity
        verify<LocalApi>(mLocalApi).techCategory
    }

    @Test
    fun givenAnObservableRootTopicsEntity() {
        val rootTopics = RootTopicsEntity()
        val fakeObservable = Observable.just(rootTopics)
        given(mLocalApi!!.trendingTopics).willReturn(fakeObservable)
    }

    @Test
    fun givenAnObservableProductEntity() {
        val rootProductEntity = RootProductEntity()
        val fakeObservable = Observable.just(rootProductEntity)
        given(mLocalApi!!.getProduct(PRODUCT_ID)).willReturn(fakeObservable)
    }

    @Test
    fun givenAnObservableTechCategoryEntity() {
        val rootEntity = RootEntity()
        val fakeObservable = Observable.just(rootEntity)
        given(mLocalApi!!.techCategory).willReturn(fakeObservable)
    }

    @Test
    fun givenAnObservableChosenTopicEntity() {
        val rootEntity = RootEntity()
        val fakeObservable = Observable.just(rootEntity)
        given(mLocalApi!!.getChosenTopic(TOPIC_ID)).willReturn(fakeObservable)
    }

    companion object {

        private const val PRODUCT_ID = "ID"

        private const val TOPIC_ID = 1
    }

}
