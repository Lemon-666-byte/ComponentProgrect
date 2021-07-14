package com.app.net

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import autodispose2.AutoDispose
import autodispose2.AutoDisposeConverter
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author Finn
 * @date 2020
 * 封装AutoDispose
 */
class RxLifecycleUtils private constructor() {
    companion object {
        fun <T> bindLifecycle(lifecycleOwner: LifecycleOwner?): AutoDisposeConverter<T> {
            return AutoDispose.autoDisposable(
                    AndroidLifecycleScopeProvider
                            .from(lifecycleOwner, Lifecycle.Event.ON_DESTROY)
            )
        }

        fun <T> ioMainScheduler(): ObservableTransformer<T, T> {
            return ObservableTransformer { upstream: Observable<T> ->
                upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            }
        }
    }

    init {
        throw IllegalStateException("Can't instance the RxLifecycleUtils")
    }
}