package com.somename.domain

import com.somename.domain.usecase.GetProduct

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

import io.reactivex.schedulers.Schedulers

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat

@RunWith(MockitoJUnitRunner::class)
class GetProductTest {

    @Mock
    private val mRepository: NetworkRepository? = null
    private var mGetProduct: GetProduct? = null
    private val mProductId = "ID"

    @Before
    fun setup() {
        mGetProduct = givenATeamByFlagUseCase()
    }

    @Test
    fun givenAConcreteUseCaseOfGetEuroTeamByFlag() {
        assertThat<GetProduct>(mGetProduct, instanceOf<Any>(GetProduct::class.java))
    }

    @Test
    fun getTeamByFlagObservableFromRepository() {
        mGetProduct!!.setProductId(mProductId)
        mGetProduct!!.createObservableUseCase()
        Mockito.verify<NetworkRepository>(mRepository).getProduct(mProductId)
        Mockito.verifyNoMoreInteractions(mRepository)
    }

    private fun givenATeamByFlagUseCase(): GetProduct {
        return GetProduct(Schedulers.trampoline(), Schedulers.trampoline(), mRepository!!)
    }
}
