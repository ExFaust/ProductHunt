package com.somename.domain.usecase;


import com.somename.domain.NetworkRepository;
import com.somename.domain.model.Root;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetChosenTopic extends UseCase<Root>{

    private final NetworkRepository mNetworkRepository;

    private int mTopicId;

    @Inject
    public GetChosenTopic(@Named("executor_thread") Scheduler executorThread,
                             @Named("ui_thread") Scheduler uiThread, NetworkRepository repository) {
        super(executorThread, uiThread);
        mNetworkRepository = repository;
    }

    @Override public Observable<Root> createObservableUseCase() {
        return this.mNetworkRepository.getChoosenTopic(mTopicId);
    }

    public void setTopicId(int topicId) {
        this.mTopicId = topicId;
    }
}
