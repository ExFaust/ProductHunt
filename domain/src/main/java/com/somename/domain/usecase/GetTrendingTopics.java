package com.somename.domain.usecase;

import com.somename.domain.NetworkRepository;
import com.somename.domain.model.RootTopics;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetTrendingTopics extends UseCase<RootTopics> {

    private final NetworkRepository nNetworkRepository;

    @Inject
    public GetTrendingTopics(@Named("executor_thread") Scheduler executorThread,
                           @Named("ui_thread") Scheduler uiThread, NetworkRepository networkRepository) {
        super(executorThread, uiThread);
        nNetworkRepository = networkRepository;
    }

    @Override
    public Observable<RootTopics> createObservableUseCase() {
        return nNetworkRepository.getTrendingTopics();
    }
}
