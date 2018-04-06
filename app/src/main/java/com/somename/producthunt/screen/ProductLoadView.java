package com.somename.producthunt.screen;

import android.support.annotation.NonNull;

import com.somename.producthunt.general.LoadingView;
import com.somename.producthunt.сontent.RootProduct;

public interface ProductLoadView extends LoadingView {

    void showError();

    void showProduct(@NonNull RootProduct root);
}
