package com.somename.producthunt.screen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.somename.producthunt.AppDelegate;
import com.somename.producthunt.R;
import com.somename.producthunt.general.LoadingDialog;
import com.somename.producthunt.general.LoadingView;
import com.somename.producthunt.screen.adapters.BaseAdapter;
import com.somename.producthunt.screen.adapters.RecyclerAdapter;
import com.somename.producthunt.screen.presenter.MainPresenter;
import com.somename.producthunt.сontent.RootViewModel;
import com.somename.producthunt.сontent.RootTopicsViewModel;
import com.somename.producthunt.сontent.TopicsViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,BaseAdapter.OnItemClickListener, MainPresenter.View{

    RecyclerView mRecyclerView;

    private LoadingView mLoadingView;

    private RecyclerAdapter mAdapter;

    private NavigationView mNavigationView;

    private SwipeRefreshLayout mSwipeContainer;

    private int selectedId;

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.tech_category));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecyclerAdapter(new ArrayList<>());
        mAdapter.attachToRecyclerView(mRecyclerView);
        mAdapter.setOnItemClickListener(this);

        mSwipeContainer = findViewById(R.id.swipeContainer);
        mSwipeContainer.setOnRefreshListener(() -> {
            mAdapter.clear();
            mPresenter.loadChoosenTopic(selectedId);
        });

        AppDelegate app = (AppDelegate) getApplication();
        app.getMainComponent().inject(this);

        mPresenter.setView(this);
        mPresenter.init();
        mPresenter.loadTrendingTopic();
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
    public void showPosts(@NonNull RootViewModel rootViewModel) {
        mSwipeContainer.setRefreshing(false);
        mAdapter.changeDataSet(rootViewModel.getPostViewModel());
    }

    @Override
    public void updateTopics(@NonNull RootTopicsViewModel rootTopicsViewModel) {
        mNavigationView.getMenu().clear();
        for (TopicsViewModel topicsViewModel : rootTopicsViewModel.getTopics()) {
            mNavigationView.getMenu().add(0, topicsViewModel.getId(),Menu.NONE, topicsViewModel.getName());
        }
    }

    @Override
    public void showError() {
        mSwipeContainer.setRefreshing(false);
        Toast.makeText(this,getString(R.string.connection_error),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(@NonNull int position) {
        Intent intent = new Intent(this,ProductActivity.class);
        intent.putExtra("productId",mAdapter.getItem(position).getId());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        setTitle(item.getTitle());
        selectedId = item.getItemId();
        mPresenter.loadChoosenTopic(selectedId);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
