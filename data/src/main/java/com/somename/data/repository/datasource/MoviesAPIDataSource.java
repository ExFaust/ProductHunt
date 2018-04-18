package com.somename.data.repository.datasource;

import com.somename.data.network.LocalApi;
import com.somename.data.сontent.RootEntity;
import com.somename.data.сontent.RootProductEntity;
import com.somename.data.сontent.RootTopicsEntity;

import io.reactivex.Observable;

public class MoviesAPIDataSource implements DataSource {

    private final LocalApi mLocalApi;

    public MoviesAPIDataSource(LocalApi localApi) {
        mLocalApi = localApi;
    }


    @Override
    public Observable<RootEntity> getTechCategoryEntity() {
        return mLocalApi.getTechCategory();
    }

    @Override
    public Observable<RootTopicsEntity> getTrendingTopicsEntity() {
        return mLocalApi.getTrendingTopics();
    }

    @Override
    public Observable<RootEntity> getChoosenTopicEntity(int topicId) {
        return mLocalApi.getChosenTopic(topicId);
    }

    @Override
    public Observable<RootProductEntity> getProductEntity(String id) {
        return mLocalApi.getProduct(id);
    }
}
