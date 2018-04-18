package com.somename.data.repository.datasource.mapper;

import com.somename.data.сontent.RootTopicsEntity;
import com.somename.data.сontent.TopicsEntity;
import com.somename.domain.model.RootTopics;
import com.somename.domain.model.Topics;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootTopicEntityMapper extends Mapper<RootTopics, RootTopicsEntity> {

    @Inject
    public RootTopicEntityMapper() {
    }

    @Override
    public RootTopicsEntity map(RootTopics rootTopics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RootTopics reverseMap(RootTopicsEntity rootTopicsEntity) {
        RootTopics rootTopics = new RootTopics();
        List<Topics> topicsList = new ArrayList<>();
        for (TopicsEntity topicsEntity: rootTopicsEntity.getTopics()) {
            Topics topics = new Topics();
            topics.setId(topicsEntity.getId());
            topics.setName(topicsEntity.getName());
            topicsList.add(topics);
        }
        rootTopics.setTopics(topicsList);
        return rootTopics;
    }
}
