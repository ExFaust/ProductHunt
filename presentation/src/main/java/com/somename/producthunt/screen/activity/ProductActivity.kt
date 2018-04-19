package com.somename.producthunt.screen.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.somename.producthunt.AppDelegate
import com.somename.producthunt.R
import com.somename.producthunt.general.LoadingDialog
import com.somename.producthunt.general.LoadingView
import com.somename.producthunt.screen.presenter.ProductPresenter
import com.somename.producthunt.сontent.RootProductViewModel
import kotlinx.android.synthetic.main.activity_product.*

import javax.inject.Inject

class ProductActivity : AppCompatActivity(), ProductPresenter.View {

    private var mLoadingView: LoadingView? = null

    @Inject
    lateinit var mPresenter: ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        mLoadingView = LoadingDialog.view(supportFragmentManager)

        val app = application as AppDelegate
        app.mainComponent?.inject(this)

        mPresenter.view = this
        mPresenter.init(intent.getStringExtra("productId"))

    }

    override fun showLoading() {
        mLoadingView!!.showLoading()
    }

    override fun hideLoading() {
        mLoadingView!!.hideLoading()
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    override fun showProduct(rootProductViewModel: RootProductViewModel) {
        val productViewModel = rootProductViewModel.productViewModel
        itemName.text = productViewModel?.name ?: ""
        itemTagline.text = productViewModel?.tagline ?: ""
        itemVotes.text = productViewModel?.votesCount ?: ""

        buttonRedirect.setOnClickListener({
            val address = Uri.parse(productViewModel?.redirectUrl)
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        })

        Glide
                .with(this)
                .load(productViewModel?.screenshotUrlViewModel?.image850px)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        itemPlaceholder.visibility = View.GONE
                        return false
                    }
                })
                .into(itemScreenshot)
    }

    public override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
