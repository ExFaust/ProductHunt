package com.somename.producthunt.repository;

import android.support.annotation.NonNull;


import com.somename.producthunt.api.ApiFactory;
import com.somename.producthunt.сontent.Root;
import com.somename.producthunt.сontent.RootTopics;

import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

public class DefaultRequest implements DefaultRequestInterface {

    @NonNull
    @Override
    public Observable<Root> tech() {
        return ApiFactory.getService()
                .tech()
                .compose(RxUtils.async());
    }

    @NonNull
    @Override
    public Observable<RootTopics> trending_topics() {
        return ApiFactory.getService()
                .trending_topics()
                .compose(RxUtils.async());
    }
}
