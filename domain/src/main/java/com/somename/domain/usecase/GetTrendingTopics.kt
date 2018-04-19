package com.somename.domain.usecase

import com.somename.domain.NetworkRepository
import com.somename.domain.model.RootTopics

import javax.inject.Inject
import javax.inject.Named

import io.reactivex.Observable
import io.reactivex.Scheduler

class GetTrendingTopics @Inject
constructor(@Named("executor_thread") executorThread: Scheduler,
            @Named("ui_thread") uiThread: Scheduler, private val nNetworkRepository: NetworkRepository) : UseCase<RootTopics>(executorThread, uiThread) {

    public override fun createObservableUseCase(): Observable<RootTopics> {
        return nNetworkRepository.trendingTopics
    }
}
