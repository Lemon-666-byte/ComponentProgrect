package com.app.api

import androidx.collection.ArrayMap
import com.app.bean.login.Login

import com.app.net.bean.BaseBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 接口请求  表单提交
 */
interface ApiLogin {

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@FieldMap map: ArrayMap<String, Any>?): Observable<BaseBean<Login?>?>

}