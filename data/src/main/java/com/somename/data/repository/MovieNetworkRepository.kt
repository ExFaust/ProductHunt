package com.somename.data.repository

import com.somename.data.repository.datasource.DataSource
import com.somename.data.repository.datasource.MoviesAPIDataSourceFactory
import com.somename.data.repository.datasource.mapper.RootEntityMapper
import com.somename.data.repository.datasource.mapper.RootProductEntityMapper
import com.somename.data.repository.datasource.mapper.RootTopicEntityMapper
import com.somename.domain.NetworkRepository
import com.somename.domain.model.Root
import com.somename.domain.model.RootProduct
import com.somename.domain.model.RootTopics

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable
import io.reactivex.annotations.NonNull

@Singleton
class MovieNetworkRepository @Inject
internal constructor(@NonNull moviesAPIDataSourceFactory: MoviesAPIDataSourceFactory, @param:NonNull private val mRootTopicEntityMapper: RootTopicEntityMapper,
                     @param:NonNull private val mRootEntityMapper: RootEntityMapper, @param:NonNull private val mRootProductEntityMapper: RootProductEntityMapper) : NetworkRepository {

    private val mDataSource: DataSource = moviesAPIDataSourceFactory.createDataSource()

    override val techCategory: Observable<Root>
        get() = mDataSource.techCategoryEntity.map(mRootEntityMapper::reverseMap)
    override val trendingTopics: Observable<RootTopics>
        get() = mDataSource.trendingTopicsEntity.map(mRootTopicEntityMapper::reverseMap)

    override fun getChoosenTopic(topicId: Int): Observable<Root> {
        return mDataSource.getChoosenTopicEntity(topicId).map(mRootEntityMapper::reverseMap)
    }

    override fun getProduct(id: String): Observable<RootProduct> {
        return mDataSource.getProductEntity(id).map(mRootProductEntityMapper::reverseMap)
    }
}
