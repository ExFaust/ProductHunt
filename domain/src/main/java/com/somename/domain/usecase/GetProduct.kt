package com.somename.domain.usecase

import com.somename.domain.NetworkRepository
import com.somename.domain.model.RootProduct

import javax.inject.Inject
import javax.inject.Named

import io.reactivex.Observable
import io.reactivex.Scheduler

class GetProduct @Inject
constructor(@Named("executor_thread") executorThread: Scheduler,
            @Named("ui_thread") uiThread: Scheduler, private val mNetworkRepository: NetworkRepository) : UseCase<RootProduct>(executorThread, uiThread) {

    private var mProductId: String? = null

    fun setProductId(productId: String) {
        mProductId = productId
    }

    public override fun createObservableUseCase(): Observable<RootProduct> {
        return mNetworkRepository.getProduct(mProductId!!)
    }
}
