package com.app.base

import autodispose2.AutoDisposeConverter
import com.app.base.mvp.BasePresenter
import com.app.base.mvp.BaseView
import com.app.net.RxLifecycleUtils
import com.app.widget.dialog.LoadingDialog

/**
 * dialog mvp 基类
 */
abstract class BaseMvpDialogFragment<V : BaseView, P : BasePresenter<V>> : BaseDialogFragment(), BaseView {

    private var loadingDialog: LoadingDialog? = null

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

    override fun showLoading(loadingText: String) {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog()
        }
        loadingDialog?.show(childFragmentManager, this.javaClass.simpleName)
    }

    override fun hideLoading() {
        loadingDialog?.dismiss()
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

    override fun showErrorView(error: String) {

    }

}