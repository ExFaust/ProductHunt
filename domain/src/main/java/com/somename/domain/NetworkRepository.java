package com.somename.domain;


import com.somename.domain.model.Root;
import com.somename.domain.model.RootProduct;
import com.somename.domain.model.RootTopics;

import io.reactivex.Observable;

public interface NetworkRepository {

    Observable<Root> getTechCategory();

    Observable<RootTopics> getTrendingTopics();

    Observable<Root> getChoosenTopic(int topicId);

    Observable<RootProduct> getProduct(String id);

}
