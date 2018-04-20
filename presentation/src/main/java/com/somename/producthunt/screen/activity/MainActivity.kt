package com.somename.producthunt.screen.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.somename.producthunt.AppDelegate
import com.somename.producthunt.R
import com.somename.producthunt.general.LoadingDialog
import com.somename.producthunt.general.LoadingView
import com.somename.producthunt.screen.adapters.BaseAdapter
import com.somename.producthunt.screen.adapters.RecyclerAdapter
import com.somename.producthunt.screen.presenter.MainPresenter
import com.somename.producthunt.сontent.RootViewModel
import com.somename.producthunt.сontent.RootTopicsViewModel

import java.util.ArrayList

import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BaseAdapter.OnItemClickListener, MainPresenter.View {

    private var mLoadingView: LoadingView? = null

    private var mAdapter: RecyclerAdapter? = null

    private var selectedId = 352

    @Inject
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        title = getString(R.string.tech_category)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        mLoadingView = LoadingDialog.view(supportFragmentManager)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = RecyclerAdapter(ArrayList())
        mAdapter!!.attachToRecyclerView(recyclerView)
        mAdapter!!.setOnItemClickListener(this)

        swipeContainer.setOnRefreshListener {
            mAdapter!!.clear()
            mPresenter.loadChoosenTopic(selectedId)
        }

        val app = application as AppDelegate
        app.mainComponent?.inject(this)

        mPresenter.view = this
        mPresenter.init()
        mPresenter.loadTrendingTopic()
    }

    override fun showLoading() {
        mLoadingView!!.showLoading()
    }

    override fun hideLoading() {
        mLoadingView!!.hideLoading()
    }

    override fun showPosts(rootViewModel: RootViewModel) {
        swipeContainer.isRefreshing = false
        rootViewModel.postViewModel?.let { mAdapter!!.changeDataSet(it) }
    }

    override fun updateTopics(rootTopicsViewModel: RootTopicsViewModel) {
        navigationView.menu.clear()
        rootTopicsViewModel.topics?.forEach { topicsViewModel -> navigationView.menu.add(0, topicsViewModel.id, Menu.NONE, topicsViewModel.name) }
    }

    override fun showError() {
        swipeContainer.isRefreshing = false
        Toast.makeText(this, getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("productId", mAdapter!!.getItem(position).id)
        startActivity(intent)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        title = item.title
        selectedId = item.itemId
        mPresenter.loadChoosenTopic(selectedId)

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
