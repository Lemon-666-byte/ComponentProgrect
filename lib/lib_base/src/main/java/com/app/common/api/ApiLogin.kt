package com.app.common.api

import androidx.collection.ArrayMap
import com.app.common.bean.base.BaseBean
import com.app.common.bean.login.Login

import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * 接口请求  表单提交
 */
interface ApiLogin {

    //获取sm2公钥
    @GET(ApiConstants.On_Get_SM2_PubK)
    fun onGetSM2PubK(): Observable<ResponseBody?>?

    @FormUrlEncoded
    @POST(ApiConstants.ON_LOGIN)
    fun login(@FieldMap map: ArrayMap<String, Any>?): Observable<Login?>

}