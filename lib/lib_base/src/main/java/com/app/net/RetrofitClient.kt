package com.app.net

import com.app.base.BuildConfig
import com.app.net.interceptor.HeadIntercept
import com.app.net.interceptor.LoggingInterceptor
import com.app.net.interceptor.TokenInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author
 * @date 2020
 * 封装Retrofit
 */
class RetrofitClient {
    private val retrofit: Retrofit

    companion object {
        val instance: RetrofitClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitClient()
        }
    }

    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
    </T> */
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

    /**
     * 设置拦截器
     *
     * @return
     */
    private val interceptor: Interceptor get() = LoggingInterceptor()

    private val tokenInterceptor: Interceptor get() = TokenInterceptor()
    private val headerInterceptor: Interceptor get() = HeadIntercept()

    init {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor) //设置Header
                .addInterceptor(interceptor) //设置拦截器
                .addInterceptor(tokenInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        okHttpClient.dispatcher.maxRequestsPerHost = 20
        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
    }
}