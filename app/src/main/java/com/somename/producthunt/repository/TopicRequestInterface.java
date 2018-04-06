package com.somename.producthunt.repository;

import android.support.annotation.NonNull;

import com.somename.producthunt.сontent.Root;
import rx.Observable;

public interface TopicRequestInterface {
    @NonNull
    Observable<Root> choosen_topic(int topicId);
}
