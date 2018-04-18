package com.somename.data.repository;

import com.somename.data.repository.datasource.DataSource;
import com.somename.data.repository.datasource.MoviesAPIDataSourceFactory;
import com.somename.data.repository.datasource.mapper.RootEntityMapper;
import com.somename.data.repository.datasource.mapper.RootProductEntityMapper;
import com.somename.data.repository.datasource.mapper.RootTopicEntityMapper;
import com.somename.domain.NetworkRepository;
import com.somename.domain.model.Root;
import com.somename.domain.model.RootProduct;
import com.somename.domain.model.RootTopics;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

@Singleton
public class MovieNetworkRepository implements NetworkRepository {

    private final DataSource mDataSource;
    private final RootTopicEntityMapper mRootTopicEntityMapper;
    private final RootEntityMapper mRootEntityMapper;
    private final RootProductEntityMapper mRootProductEntityMapper;

    @Inject
    MovieNetworkRepository(@NonNull MoviesAPIDataSourceFactory moviesAPIDataSourceFactory, @NonNull RootTopicEntityMapper rootTopicEntityMapper,
                           @NonNull RootEntityMapper rootEntityMapper, @NonNull RootProductEntityMapper rootProductEntityMapper) {
        mDataSource = moviesAPIDataSourceFactory.createDataSource();
        mRootTopicEntityMapper = rootTopicEntityMapper;
        mRootEntityMapper = rootEntityMapper;
        mRootProductEntityMapper = rootProductEntityMapper;
    }


    @Override
    public Observable<Root> getTechCategory() {
        return mDataSource.getTechCategoryEntity().map(mRootEntityMapper::reverseMap);
    }

    @Override
    public Observable<RootTopics> getTrendingTopics() {
        return mDataSource.getTrendingTopicsEntity().map(mRootTopicEntityMapper::reverseMap);
    }

    @Override
    public Observable<Root> getChoosenTopic(int topicId) {
        return mDataSource.getChoosenTopicEntity(topicId).map(mRootEntityMapper::reverseMap);
    }

    @Override
    public Observable<RootProduct> getProduct(String id) {
        return mDataSource.getProductEntity(id).map(mRootProductEntityMapper::reverseMap);
    }
}
