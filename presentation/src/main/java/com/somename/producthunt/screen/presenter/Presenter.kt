package com.somename.producthunt.screen.presenter

open class Presenter<T : Presenter.View> {

    var view: T? = null

    interface View {

        fun showLoading()

        fun hideLoading()

        fun showError()
    }
}
