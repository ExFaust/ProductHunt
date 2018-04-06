package com.somename.producthunt.repository;

import android.support.annotation.NonNull;

import com.somename.producthunt.сontent.Root;
import com.somename.producthunt.сontent.RootTopics;

import rx.Observable;

public interface DefaultRequestInterface {

    @NonNull
    Observable<Root> tech();

    @NonNull
    Observable<RootTopics> trending_topics();

}
