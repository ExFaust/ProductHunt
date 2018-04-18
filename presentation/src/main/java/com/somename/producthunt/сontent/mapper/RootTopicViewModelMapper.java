package com.somename.producthunt.сontent.mapper;

import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.domain.model.RootTopics;
import com.somename.domain.model.Topics;
import com.somename.producthunt.сontent.RootTopicsViewModel;
import com.somename.producthunt.сontent.TopicsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootTopicViewModelMapper extends Mapper<RootTopics, RootTopicsViewModel> {

    @Inject
    public RootTopicViewModelMapper() {
    }

    @Override
    public RootTopicsViewModel map(RootTopics rootTopics) {
        RootTopicsViewModel rootTopicsViewModel = new RootTopicsViewModel();
        List<TopicsViewModel> topicsViewModels = new ArrayList<>();
        for (Topics topics: rootTopics.getTopics()) {
            TopicsViewModel topicsViewModel = new TopicsViewModel();
            topicsViewModel.setId(topics.getId());
            topicsViewModel.setName(topics.getName());
            topicsViewModels.add(topicsViewModel);
        }
        rootTopicsViewModel.setTopics(topicsViewModels);
        return rootTopicsViewModel;
    }

    @Override
    public RootTopics reverseMap(RootTopicsViewModel rootTopicsViewModel) {
        throw new UnsupportedOperationException();
    }
}
