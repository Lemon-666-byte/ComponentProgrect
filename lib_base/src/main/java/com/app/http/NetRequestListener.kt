package com.app.http

/**
 * @author Finn
 * @date 2020
 */
interface NetRequestListener<T> {
    fun onSuccess(result: T?)
    fun onFailed(e: Throwable?)
}