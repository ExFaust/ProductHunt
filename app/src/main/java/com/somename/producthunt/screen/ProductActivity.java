package com.somename.producthunt.screen;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.somename.producthunt.R;
import com.somename.producthunt.general.LoadingDialog;
import com.somename.producthunt.general.LoadingView;
import com.somename.producthunt.сontent.Product;
import com.somename.producthunt.сontent.Root;
import com.somename.producthunt.сontent.RootProduct;

public class ProductActivity extends AppCompatActivity implements ProductLoadView {

    private LoadingView mLoadingView;

    private ProductPresenter mPresenter;

    private TextView mTextViewName;

    private TextView mTextViewTagline;

    private TextView mTextViewVotes;

    private ImageView mImageViewScreenshot;

    private ProgressBar mProgressBar;

    private Button mButtonRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        mPresenter = new ProductPresenter(this);
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
    public void showProduct(@NonNull RootProduct root) {
        Product product = root.getProduct();
        mTextViewName.setText(product.getName());
        mTextViewTagline.setText(product.getTagline());
        mTextViewVotes.setText(product.getVotesCount());

        mButtonRedirect.setOnClickListener(view -> {
            Uri address = Uri.parse(product.getRedirectUrl());
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openLinkIntent);
        });

        Glide
                .with(this)
                .load(product.getScreenshotUrl().getImage850px())
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
}
