package com.app.base.mvp

import com.app.http.NetObserver
import com.app.http.NetRequestListener
import com.app.http.RxLifecycleUtils
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import java.lang.ref.WeakReference

/**
 * @author
 * @date 2020
 */

open class BasePresenter<V : BaseView> {

    private var pView: WeakReference<V>? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    fun attachView(view: V) {
        this.pView = WeakReference(view)
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */
    fun detachView() {
        this.pView?.clear()
    }

    fun getView(): V? {
        return pView?.get()
    }

    /**
     * requestNetwork
     *
     * @param observable
     * @param listener
     * @param compose
     * @param <T>
    </T> */
    private fun <T> requestNetwork(observable: Observable<T>, listener: NetRequestListener<T>?, compose: ObservableTransformer<T, T>) {
        val dispose = getView()?.bindAutoDispose<Any>()
        if (dispose == null) {
            observable.compose(compose)
                    .subscribe(object : NetObserver<T>() {
                        override fun onSuccess(result: T) {
                            listener?.onSuccess(result)
                            getView()?.hideLoading()
                        }

                        override fun onFailure(e: Throwable?) {
                            listener?.onFailed(e)
                            getView()?.hideLoading()
                        }
                    })
        } else {
            observable.compose(compose).to(getView()?.bindAutoDispose()) //绑定 AutoDispose，跟随view生命周期
                    .subscribe(object : NetObserver<T>() {
                        override fun onSuccess(result: T) {
                            listener?.onSuccess(result)
                            getView()?.hideLoading()
                        }

                        override fun onFailure(e: Throwable?) {
                            listener?.onFailed(e)
                            getView()?.hideLoading()
                        }
                    })
        }

    }

    fun <T> requestNetwork(observable: Observable<T>, observer: NetRequestListener<T>) {
        requestNetwork(observable, observer, RxLifecycleUtils.ioMainScheduler())
    }


}