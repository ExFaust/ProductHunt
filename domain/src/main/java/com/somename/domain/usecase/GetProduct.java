package com.somename.domain.usecase;

import com.somename.domain.NetworkRepository;
import com.somename.domain.model.RootProduct;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetProduct extends UseCase<RootProduct> {

    private final NetworkRepository mNetworkRepository;

    private String mProductId;

    @Inject
    public GetProduct(@Named("executor_thread") Scheduler executorThread,
                             @Named("ui_thread") Scheduler uiThread, NetworkRepository networkRepository) {
        super(executorThread, uiThread);
        mNetworkRepository = networkRepository;
    }

    public void setProductId(String productId) {
        this.mProductId = productId;
    }

    @Override
    public Observable<RootProduct> createObservableUseCase() {
        return mNetworkRepository.getProduct(mProductId);
    }
}
