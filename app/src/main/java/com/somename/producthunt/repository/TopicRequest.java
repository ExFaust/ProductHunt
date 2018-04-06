package com.somename.producthunt.repository;

import android.support.annotation.NonNull;

import com.somename.producthunt.api.ApiFactory;
import com.somename.producthunt.сontent.Root;

import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

public class TopicRequest implements TopicRequestInterface{

    @NonNull
    @Override
    public Observable<Root> choosen_topic(int topicId) {
        return ApiFactory.getService()
                .choosen_topic(topicId)
                .compose(RxUtils.async());
    }
}
