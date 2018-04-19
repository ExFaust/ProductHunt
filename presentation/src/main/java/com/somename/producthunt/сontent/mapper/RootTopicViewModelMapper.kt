package com.somename.producthunt.сontent.mapper

import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.RootTopics
import com.somename.producthunt.сontent.RootTopicsViewModel
import com.somename.producthunt.сontent.TopicsViewModel

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootTopicViewModelMapper @Inject
constructor() : Mapper<RootTopics, RootTopicsViewModel>() {

    override fun map(value: RootTopics): RootTopicsViewModel {
        val rootTopicsViewModel = RootTopicsViewModel()
        val topicsViewModels = ArrayList<TopicsViewModel>()
        value.topics?.forEach { topics ->
            val topicsViewModel = TopicsViewModel()
            topicsViewModel.id = topics.id
            topicsViewModel.name = topics.name
            topicsViewModels.add(topicsViewModel)
        }
        rootTopicsViewModel.topics = topicsViewModels
        return rootTopicsViewModel
    }

    override fun reverseMap(value: RootTopicsViewModel): RootTopics {
        throw UnsupportedOperationException()
    }
}
