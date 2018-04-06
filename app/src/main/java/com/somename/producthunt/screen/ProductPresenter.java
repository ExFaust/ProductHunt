package com.somename.producthunt.screen;


import android.support.annotation.NonNull;

import com.somename.producthunt.repository.ProductRequestProvider;
import com.somename.producthunt.repository.RequestProvider;

public class ProductPresenter {

    private final ProductLoadView mLoadView;

    public ProductPresenter(@NonNull ProductLoadView loadView) {
        mLoadView = loadView;
    }

    public void init(String id) {
        ProductRequestProvider.provideRequest()
                .product(id)
                .doOnSubscribe(mLoadView::showLoading)
                .doOnTerminate(mLoadView::hideLoading)
                .subscribe(mLoadView::showProduct, throwable -> mLoadView.showError());

    }


}
