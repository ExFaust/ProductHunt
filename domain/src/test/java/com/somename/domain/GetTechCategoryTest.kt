package com.somename.domain

import com.somename.domain.usecase.GetTechCategory
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
class GetTechCategoryTest {

    @Mock
    private val mRepository: NetworkRepository?=null
    private var mGetTechCategory: GetTechCategory?=null

    @Before
    fun setup() {
        mGetTechCategory = givenATeamByFlagUseCase()
    }

    @Test
    fun givenAConcreteUseCaseOfGetEuroTeamByFlag() {
        assertThat<GetTechCategory> (mGetTechCategory, instanceOf < Any > (GetTechCategory:: class.java))
    }

    @Test
    fun getTeamByFlagObservableFromRepository() {
        mGetTechCategory !!.createObservableUseCase()
        Mockito.verify<NetworkRepository> (mRepository).techCategory
        Mockito.verifyNoMoreInteractions(mRepository)
    }

    private fun givenATeamByFlagUseCase():GetTechCategory

    {
        return GetTechCategory(Schedulers.trampoline(), Schedulers.trampoline(), mRepository !!)
    }
}