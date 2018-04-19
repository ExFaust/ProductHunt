package com.somename.domain.usecase


import com.somename.domain.NetworkRepository
import com.somename.domain.model.Root

import javax.inject.Inject
import javax.inject.Named

import io.reactivex.Observable
import io.reactivex.Scheduler

class GetChosenTopic @Inject
constructor(@Named("executor_thread") executorThread: Scheduler,
            @Named("ui_thread") uiThread: Scheduler, private val mNetworkRepository: NetworkRepository) : UseCase<Root>(executorThread, uiThread) {

    private var mTopicId: Int = 0

    public override fun createObservableUseCase(): Observable<Root> {
        return this.mNetworkRepository.getChoosenTopic(mTopicId)
    }

    fun setTopicId(topicId: Int) {
        this.mTopicId = topicId
    }
}
