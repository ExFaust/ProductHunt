package com.somename.domain

import com.somename.domain.usecase.GetTrendingTopics
import io.reactivex.schedulers.Schedulers
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetTrendingTopicsTest {

    @Mock
    private val mRepository: NetworkRepository?=null
    private var mGetTrendingTopics: GetTrendingTopics?=null

    @Before
    fun setup() {
        mGetTrendingTopics = givenATeamByFlagUseCase()
    }

    @Test
    fun givenAConcreteUseCaseOfGetEuroTeamByFlag() {
        assertThat<GetTrendingTopics> (mGetTrendingTopics, instanceOf < Any > (GetTrendingTopics:: class.java))
    }

    @Test
    fun getTeamByFlagObservableFromRepository() {
        mGetTrendingTopics !!.createObservableUseCase()
        Mockito.verify<NetworkRepository> (mRepository).trendingTopics
        Mockito.verifyNoMoreInteractions(mRepository)
    }

    private fun givenATeamByFlagUseCase():GetTrendingTopics

    {
        return GetTrendingTopics(Schedulers.trampoline(), Schedulers.trampoline(), mRepository !!)
    }
}