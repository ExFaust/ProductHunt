package com.somename.data.repository.datasource.mapper

import com.somename.data.сontent.RootTopicsEntity
import com.somename.domain.model.RootTopics
import com.somename.domain.model.Topics

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootTopicEntityMapper @Inject
constructor() : Mapper<RootTopics, RootTopicsEntity>() {

    override fun map(value: RootTopics): RootTopicsEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: RootTopicsEntity): RootTopics {
        val rootTopics = RootTopics()
        val topicsList = ArrayList<Topics>()
        value.topics?.forEach { topicsEntity ->
            val topics = Topics()
            topics.id = topicsEntity.id
            topics.name = topicsEntity.name
            topicsList.add(topics)
        }
        rootTopics.topics = topicsList
        return rootTopics
    }
}
