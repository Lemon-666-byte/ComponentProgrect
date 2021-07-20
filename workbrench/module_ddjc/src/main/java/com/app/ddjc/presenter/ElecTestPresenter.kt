package com.app.ddjc.presenter

import com.app.base.mvp.BasePresenter
import com.app.common.bean.login.Login
import com.app.ddjc.contract.ElecTestContract
import com.app.net.NetRequestListener
import com.app.net.utils.ApiServiceUtils
import com.app.net.utils.ParamsMapUtils

/**
 * 带电检测
 */
open class ElecTestPresenter : BasePresenter<ElecTestContract.View>(), ElecTestContract.Presenter {

    override fun login(name: String, password: String, mobileLogin: Boolean) {
        getView()?.showLoading()
        val params = ParamsMapUtils.commonParams
        params["username"] = name
        params["password"] = password
        params["mobileLogin"] = mobileLogin

        requestNetwork(ApiServiceUtils.apiLogin.login(params), object :
            NetRequestListener<Login?> {
            override fun onSuccess(result: Login?) {
                getView()?.hideLoading()
                getView()?.handleLogin(result)
            }

            override fun onFailed(e: Throwable?) {
                getView()?.hideLoading()
                getView()?.handleLogin(null)
                getView()?.onError(e)
            }
        })
    }




}