package com.app.base

import autodispose2.AutoDisposeConverter
import com.app.base.mvp.BasePresenter
import com.app.base.mvp.BaseView
import com.app.http.RxLifecycleUtils
import com.app.widget.dialog.LoadingDialog

abstract class BaseMvpActivity<V : BaseView, P : BasePresenter<V>> : BaseActivity(), BaseView {

    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog()
    }

    protected var mPresenter: P? = null

    protected abstract fun getPresenter(): P

    override fun initPresenter() {
        mPresenter = getPresenter()
        mPresenter?.attachView(this as V)
    }


    override fun onDestroy() {
        hideLoading()
        mPresenter?.detachView()
        mPresenter = null
        super.onDestroy()
    }

    override fun showLoading(loadingText: String) {
        loadingDialog.show(supportFragmentManager)
    }


    override fun hideLoading() {
        loadingDialog.dismiss()
    }

    override fun showErrorView(error: String) {

    }

    override fun onError(throwable: Throwable?) {

    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    override fun <T> bindAutoDispose(): AutoDisposeConverter<T> {
        return RxLifecycleUtils.bindLifecycle(this)
    }
}