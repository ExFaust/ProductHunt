package com.somename.data.repository


import com.somename.data.network.LocalApi
import com.somename.data.repository.datasource.APIDataSource
import com.somename.data.repository.datasource.APIDataSourceFactory
import com.somename.data.repository.datasource.DataSource
import org.junit.Before
import org.junit.Test

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class APIDataSourceFactoryTest {

    @Mock
    private val mLocalApi: LocalApi? = null

    private var mApiDataSourceFactory: APIDataSourceFactory? = null

    @Before
    fun setUp() {
        mApiDataSourceFactory = APIDataSourceFactory(mLocalApi!!)
    }

    @Test
    fun givenAnInstanceLocalApiDataSource() {
        val dataSource = mApiDataSourceFactory!!.createDataSource()
        assertThat<DataSource>(dataSource, `is`(notNullValue()))
        assertThat<DataSource>(dataSource, `is`(instanceOf<Any>(APIDataSource::class.java)))
    }
}
