package com.somename.producthunt.screen.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.somename.producthunt.AppDelegate;
import com.somename.producthunt.R;
import com.somename.producthunt.general.LoadingDialog;
import com.somename.producthunt.general.LoadingView;
import com.somename.producthunt.screen.presenter.ProductPresenter;
import com.somename.producthunt.сontent.ProductViewModel;
import com.somename.producthunt.сontent.RootProductViewModel;

import javax.inject.Inject;

public class ProductActivity extends AppCompatActivity implements ProductPresenter.View {

    private LoadingView mLoadingView;

    private TextView mTextViewName;

    private TextView mTextViewTagline;

    private TextView mTextViewVotes;

    private ImageView mImageViewScreenshot;

    private ProgressBar mProgressBar;

    private Button mButtonRedirect;

    @Inject
    ProductPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        AppDelegate app = (AppDelegate) getApplication();
        app.getMainComponent().inject(this);

        mPresenter.setView(this);
        mPresenter.init(getIntent().getStringExtra("productId"));

        mTextViewName = findViewById(R.id.item_name);
        mTextViewTagline = findViewById(R.id.item_tagline);
        mTextViewVotes = findViewById(R.id.item_votes);
        mImageViewScreenshot = findViewById(R.id.item_screenshot);
        mProgressBar = findViewById(R.id.item_placeholder);
        mButtonRedirect = findViewById(R.id.button_redirect);
    }

    @Override
    public void showLoading() {
        mLoadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

    @Override
    public void showError() {
        Toast.makeText(this,getString(R.string.connection_error),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProduct(@NonNull RootProductViewModel root) {
        ProductViewModel productViewModel = root.getProductViewModel();
        mTextViewName.setText(productViewModel.getName());
        mTextViewTagline.setText(productViewModel.getTagline());
        mTextViewVotes.setText(productViewModel.getVotesCount());

        mButtonRedirect.setOnClickListener(view -> {
            Uri address = Uri.parse(productViewModel.getRedirectUrl());
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openLinkIntent);
        });

        Glide
                .with(this)
                .load(productViewModel.getScreenshotUrlViewModel().getImage850px())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        mProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(mImageViewScreenshot);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
