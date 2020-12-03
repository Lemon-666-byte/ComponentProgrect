package com.app.base

import com.app.base.mvp.BasePresenter
import com.app.base.mvp.BaseView

abstract class BaseMvpFragment<V : BaseView, P : BasePresenter<V>> : BaseFragment() {

    protected var mPresenter: P? = null

    protected abstract fun getPresenter(): P

    override fun initPresenter() {
        mPresenter = getPresenter()
        mPresenter?.attachView(this as V)
    }


    override fun onDestroy() {
        super.onDestroy()
        hideLoading()
        mPresenter?.detachView()
        mPresenter = null
    }

}