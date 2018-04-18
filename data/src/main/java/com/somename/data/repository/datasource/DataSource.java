package com.somename.data.repository.datasource;

import com.somename.data.сontent.RootEntity;
import com.somename.data.сontent.RootProductEntity;
import com.somename.data.сontent.RootTopicsEntity;

import io.reactivex.Observable;

public interface DataSource {

    Observable<RootEntity> getTechCategoryEntity();

    Observable<RootTopicsEntity> getTrendingTopicsEntity();

    Observable<RootEntity> getChoosenTopicEntity(int topicId);

    Observable<RootProductEntity> getProductEntity(String id);

}
