package com.somename.domain

import com.somename.domain.usecase.GetChosenTopic
import io.reactivex.schedulers.Schedulers
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetChosenTopicTest {

    @Mock
    private val mRepository: NetworkRepository? = null
    private var mGetChosenTopic: GetChosenTopic? = null
    private val mTopicId = 1

    @Before
    fun setUp() {
        mGetChosenTopic = givenChosenTopicUseCase()
    }

    @Test
    fun givenAConcreteUseCaseOfGetChosenTopic() {
        assertThat<GetChosenTopic>(mGetChosenTopic, instanceOf<Any>(GetChosenTopic::class.java))
    }

    @Test
    fun getChosenTopicObservableFromRepository() {
        mGetChosenTopic!!.setTopicId(mTopicId)
        mGetChosenTopic!!.createObservableUseCase()
        verify(mRepository)?.getChosenTopic(mTopicId)
        verifyNoMoreInteractions(mRepository)
    }

    private fun givenChosenTopicUseCase(): GetChosenTopic {
        return GetChosenTopic(Schedulers.trampoline(), Schedulers.trampoline(), mRepository!!)
    }
}