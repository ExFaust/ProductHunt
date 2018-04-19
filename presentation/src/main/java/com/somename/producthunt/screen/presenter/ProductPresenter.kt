package com.somename.producthunt.screen.presenter


import com.somename.domain.model.RootProduct
import com.somename.domain.usecase.GetProduct
import com.somename.producthunt.сontent.RootProductViewModel
import com.somename.producthunt.сontent.mapper.RootProductViewModelMapper

import javax.inject.Inject

import io.reactivex.observers.DisposableObserver

class ProductPresenter @Inject
constructor(private val mGetProduct: GetProduct, private val mRootProductViewModelMapper: RootProductViewModelMapper) : Presenter<ProductPresenter.View>() {

    fun init(id: String) {
        view?.showLoading()
        mGetProduct.setProductId(id)
        mGetProduct.execute(object : DisposableObserver<RootProduct>() {
            override fun onNext(rootProduct: RootProduct) {
                view?.showProduct(mRootProductViewModelMapper.map(rootProduct))
            }

            override fun onError(e: Throwable) {
                view?.hideLoading()
                view?.showError()
                e.printStackTrace()
            }

            override fun onComplete() {
                view?.hideLoading()
            }
        })
    }

    fun onDestroy() {
        mGetProduct.dispose()
    }

    interface View : Presenter.View {

        fun showProduct(rootProductViewModel: RootProductViewModel)

    }
}
