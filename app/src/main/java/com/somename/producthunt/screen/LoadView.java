package com.somename.producthunt.screen;

import android.support.annotation.NonNull;

import com.somename.producthunt.general.LoadingView;
import com.somename.producthunt.сontent.Root;
import com.somename.producthunt.сontent.RootTopics;

public interface LoadView extends LoadingView {

    void showError();

    void showPosts(@NonNull Root root);

    void updateTopics(@NonNull RootTopics topics);

}