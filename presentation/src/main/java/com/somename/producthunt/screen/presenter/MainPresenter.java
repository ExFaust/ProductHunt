package com.somename.producthunt.screen.presenter;

import android.support.annotation.NonNull;

import com.somename.domain.model.Root;
import com.somename.domain.model.RootTopics;
import com.somename.domain.usecase.GetChosenTopic;
import com.somename.domain.usecase.GetTechCategory;
import com.somename.domain.usecase.GetTrendingTopics;
import com.somename.producthunt.сontent.RootTopicsViewModel;
import com.somename.producthunt.сontent.RootViewModel;
import com.somename.producthunt.сontent.mapper.RootTopicViewModelMapper;
import com.somename.producthunt.сontent.mapper.RootViewModelMapper;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;


public class MainPresenter extends Presenter<MainPresenter.View>{

    private final GetTechCategory mGetTechCategory;

    private final GetTrendingTopics mGetTrendingTopics;

    private final GetChosenTopic mGetChosenTopic;

    private RootViewModelMapper mRootViewModelMapper;

    private RootTopicViewModelMapper mRootTopicViewModelMapper;

    @Inject
    public MainPresenter(@NonNull GetTechCategory getTechCategory, @NonNull GetTrendingTopics getTrendingTopics,
                         @NonNull GetChosenTopic getChosenTopic, @NonNull RootViewModelMapper rootViewModelMapper,
                         @NonNull RootTopicViewModelMapper rootTopicViewModelMapper) {
        mGetChosenTopic = getChosenTopic;
        mGetTechCategory = getTechCategory;
        mGetTrendingTopics = getTrendingTopics;
        mRootViewModelMapper = rootViewModelMapper;
        mRootTopicViewModelMapper = rootTopicViewModelMapper;
    }

    public void init() {
        getView().showLoading();
        mGetTechCategory.execute(new DisposableObserver<Root>() {
            @Override
            public void onNext(Root root) {
                getView().showPosts(mRootViewModelMapper.map(root));
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

    public void loadTrendingTopic(){
        getView().showLoading();
        mGetTrendingTopics.execute(new DisposableObserver<RootTopics>() {
            @Override
            public void onNext(RootTopics rootTopics) {
                getView().updateTopics(mRootTopicViewModelMapper.map(rootTopics));
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

    public void loadChoosenTopic(int topicId){
        getView().showLoading();
        mGetChosenTopic.setTopicId(topicId);
        mGetChosenTopic.execute(new DisposableObserver<Root>() {
            @Override
            public void onNext(Root root) {
                getView().showPosts(mRootViewModelMapper.map(root));
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
        mGetTechCategory.dispose();
        mGetTrendingTopics.dispose();
        mGetChosenTopic.dispose();
    }

    public interface View extends Presenter.View {

        void showPosts(RootViewModel rootViewModel);

        void updateTopics(RootTopicsViewModel rootTopicsViewModel);
    }

}
