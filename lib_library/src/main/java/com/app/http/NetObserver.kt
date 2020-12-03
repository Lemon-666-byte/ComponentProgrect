package com.app.http

import com.blankj.utilcode.util.LogUtils
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observer

import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author
 * @date 2020
 * 封装Observer，统一处理
 */
abstract class NetObserver<T> : Observer<T> {
    private var disposable: Disposable? = null

    abstract fun onSuccess(result: T)

    abstract fun onFailure(e: Throwable?)

    override fun onSubscribe(d: @NonNull Disposable) {
        disposable = d
    }

    override fun onNext(result: @NonNull T) {
        onSuccess(result)
    }

    override fun onError(e: @NonNull Throwable) {
        LogUtils.e(e)
        onFailure(e)
        //事件完成取消订阅
        disposable?.let {
            if (!it.isDisposed)
                it.dispose()
        }
    }

    override fun onComplete() {
        disposable?.let {
            if (!it.isDisposed)
                it.dispose()
        }
    }
}