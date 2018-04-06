package com.somename.producthunt.screen;

import android.support.annotation.NonNull;
import com.somename.producthunt.repository.RequestProvider;
import com.somename.producthunt.repository.TopicRequestProvider;


public class MainPresenter {

    private final LoadView mLoadView;

    public MainPresenter(@NonNull LoadView loadView) {
        mLoadView = loadView;
    }

    public void init() {
        RequestProvider.provideRequest()
                .tech()
                .doOnSubscribe(mLoadView::showLoading)
                .doOnTerminate(mLoadView::hideLoading)
                .subscribe(mLoadView::showPosts, throwable -> mLoadView.showError());

        RequestProvider.provideRequest()
                .trending_topics()
                .doOnSubscribe(mLoadView::showLoading)
                .doOnTerminate(mLoadView::hideLoading)
                .subscribe(mLoadView::updateTopics, throwable -> mLoadView.showError());
    }

    public void loadChoosenTopic(int topicId){
        TopicRequestProvider.provideRequest()
                .choosen_topic(topicId)
                .doOnSubscribe(mLoadView::showLoading)
                .doOnTerminate(mLoadView::hideLoading)
                .subscribe(mLoadView::showPosts, throwable -> mLoadView.showError());
    }

}
