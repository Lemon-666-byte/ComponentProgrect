package com.app.base

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import autodispose2.AutoDisposeConverter
import com.app.base.mvp.BasePresenter
import com.app.base.mvp.BaseView
import com.app.http.RxLifecycleUtils
import com.blankj.utilcode.util.ActivityUtils

/**
 * header
 */
abstract class BaseMvpHeaderView<V : BaseView, P : BasePresenter<V>>(context: Context) : BaseHeaderView(context), BaseView {
    protected var mPresenter: P? = null

    protected abstract fun getPresenter(): P

    override fun initPresenter() {
        mPresenter = getPresenter()
        mPresenter?.attachView(this as V)
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mPresenter?.detachView()
        mPresenter = null
    }

    override fun showLoading(loadingText: String) {
    }

    override fun hideLoading() {

    }

    override fun showErrorView(error: String) {
    }

    override fun onError(throwable: Throwable?) {
    }

    override fun <T> bindAutoDispose(): AutoDisposeConverter<T>? {
        return null
    }
}