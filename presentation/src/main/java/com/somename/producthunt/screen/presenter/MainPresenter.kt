package com.somename.producthunt.screen.presenter

import com.somename.domain.model.Root
import com.somename.domain.model.RootTopics
import com.somename.domain.usecase.GetChosenTopic
import com.somename.domain.usecase.GetTechCategory
import com.somename.domain.usecase.GetTrendingTopics
import com.somename.producthunt.сontent.RootTopicsViewModel
import com.somename.producthunt.сontent.RootViewModel
import com.somename.producthunt.сontent.mapper.RootTopicViewModelMapper
import com.somename.producthunt.сontent.mapper.RootViewModelMapper

import javax.inject.Inject

import io.reactivex.observers.DisposableObserver


class MainPresenter @Inject
constructor(private val mGetTechCategory: GetTechCategory, private val mGetTrendingTopics: GetTrendingTopics,
            private val mGetChosenTopic: GetChosenTopic, private val mRootViewModelMapper: RootViewModelMapper,
            private val mRootTopicViewModelMapper: RootTopicViewModelMapper) : Presenter<MainPresenter.View>() {

    fun init() {
        view?.showLoading()
        mGetTechCategory.execute(object : DisposableObserver<Root>() {
            override fun onNext(root: Root) {
                view?.showPosts(mRootViewModelMapper.map(root))
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

    fun loadTrendingTopic() {
        view?.showLoading()
        mGetTrendingTopics.execute(object : DisposableObserver<RootTopics>() {
            override fun onNext(rootTopics: RootTopics) {
                view?.updateTopics(mRootTopicViewModelMapper.map(rootTopics))
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

    fun loadChoosenTopic(topicId: Int) {
        view?.showLoading()
        mGetChosenTopic.setTopicId(topicId)
        mGetChosenTopic.execute(object : DisposableObserver<Root>() {
            override fun onNext(root: Root) {
                view?.showPosts(mRootViewModelMapper.map(root))
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
        mGetTechCategory.dispose()
        mGetTrendingTopics.dispose()
        mGetChosenTopic.dispose()
    }

    interface View : Presenter.View {

        fun showPosts(rootViewModel: RootViewModel)

        fun updateTopics(rootTopicsViewModel: RootTopicsViewModel)
    }

}
