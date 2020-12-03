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

//    /**
//     * 设置加载数据结果
//     *
//     * @param baseQuickAdapter
//     * @param refreshLayout
//     * @param list
//     * @param loadType
//     */
//    protected open fun setLoadDataResult(baseQuickAdapter: BaseQuickAdapter<Any, *>?, refreshLayout: SwipeRefreshLayout, list: List<Any>, @LoadType.checker loadType: Int) {
//        setLoadDataResult(baseQuickAdapter, refreshLayout, list, loadType, getString(R.string.empty_no_data))
//    }
//
//    /**
//     * @param baseQuickAdapter
//     * @param refreshLayout
//     * @param list
//     * @param loadType
//     * @param emptyStr
//     */
//    protected open fun setLoadDataResult(baseQuickAdapter: BaseQuickAdapter<Any, *>?, refreshLayout: SwipeRefreshLayout?, list: List<Any>, @LoadType.checker loadType: Int, emptyStr: String?) {
//        refreshLayout?.isRefreshing = false
//        if (baseQuickAdapter == null) return
//        val loadMoreModule = baseQuickAdapter.loadMoreModule
//        if (list.isNullOrEmpty()) {
//            if (LoadType.TYPE_REFRESH_SUCCESS == loadType) {
//                baseQuickAdapter.data.clear()
//                emptyView.setEmptyViewText(emptyStr)
//                loadMoreModule.loadMoreComplete()
//                baseQuickAdapter.setEmptyView(emptyView)
//            } else if (LoadType.TYPE_LOAD_MORE_SUCCESS == loadType) {
//                loadMoreModule.loadMoreEnd()
//            }
//        } else {
//            if (LoadType.TYPE_REFRESH_SUCCESS == loadType) {
//                baseQuickAdapter.setDiffNewData(list)
//            } else if (LoadType.TYPE_LOAD_MORE_SUCCESS == loadType) {
//                baseQuickAdapter.addData(list)
//            }
//            loadMoreModule.loadMoreComplete()
//            //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
//            loadMoreModule.isEnableLoadMoreIfNotFullPage = false
//        }
//        if (LoadType.TYPE_REFRESH_ERROR == loadType || LoadType.TYPE_LOAD_MORE_ERROR == loadType) {
//            loadMoreModule.loadMoreFail()
//        }
//        if (baseQuickAdapter.data.isNullOrEmpty()) {
//            if (LoadType.TYPE_REFRESH_ERROR == loadType) {
//                baseQuickAdapter.setEmptyView(R.layout.view_network_error_view)
//            } else {
//                baseQuickAdapter.setEmptyView(emptyView)
//            }
//        }
//}
}