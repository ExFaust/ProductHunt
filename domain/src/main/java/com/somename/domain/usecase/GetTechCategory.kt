package com.somename.domain.usecase

import com.somename.domain.NetworkRepository
import com.somename.domain.model.Root

import javax.inject.Inject
import javax.inject.Named

import io.reactivex.Observable
import io.reactivex.Scheduler

class GetTechCategory @Inject
constructor(@Named("executor_thread") executorThread: Scheduler,
            @Named("ui_thread") uiThread: Scheduler, private val mNetworkRepository: NetworkRepository) : UseCase<Root>(executorThread, uiThread) {

    public override fun createObservableUseCase(): Observable<Root> {
        return this.mNetworkRepository.techCategory
    }
}
