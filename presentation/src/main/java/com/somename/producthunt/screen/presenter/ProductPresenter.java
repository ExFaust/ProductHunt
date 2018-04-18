package com.somename.producthunt.screen.presenter;


import android.support.annotation.NonNull;

import com.somename.domain.model.RootProduct;
import com.somename.domain.usecase.GetProduct;
import com.somename.producthunt.сontent.RootProductViewModel;
import com.somename.producthunt.сontent.mapper.RootProductViewModelMapper;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class ProductPresenter extends Presenter<ProductPresenter.View>{

    private final GetProduct mGetProduct;

    private RootProductViewModelMapper mRootProductViewModelMapper;

    @Inject
    public ProductPresenter(@NonNull GetProduct getProduct, @NonNull RootProductViewModelMapper rootProductViewModelMapper) {
        mGetProduct = getProduct;
        mRootProductViewModelMapper = rootProductViewModelMapper;
    }

    public void init(String id) {
        getView().showLoading();
        mGetProduct.setProductId(id);
        mGetProduct.execute(new DisposableObserver<RootProduct>() {
            @Override
            public void onNext(RootProduct rootProduct) {
                getView().showProduct(mRootProductViewModelMapper.map(rootProduct));
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().showError();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    public void onDestroy() {
        mGetProduct.dispose();
    }

    public interface View extends Presenter.View {

        void showProduct(RootProductViewModel rootProductViewModel);

    }
}
