package com.app.base.mvp

import autodispose2.AutoDisposeConverter


interface BaseView {
    /**
     * 显示加载中
     */
    fun showLoading(loadingText: String = "")

    /**
     * 隐藏加载
     */
    fun hideLoading()

    /**
     * 隐藏加载
     */
    fun showErrorView(error: String = "")

    /**
     * 数据获取失败
     * @param throwable
     */
    fun onError(throwable: Throwable?)

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    fun <T> bindAutoDispose(): AutoDisposeConverter<T>?
}