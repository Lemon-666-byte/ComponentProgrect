package com.app.login.presenter

import com.app.base.mvp.BasePresenter
import com.app.common.bean.base.BaseBean
import com.app.common.bean.login.Login
import com.app.login.contract.LoginContract
import com.app.net.NetRequestListener
import com.app.net.utils.ApiServiceUtils
import com.app.net.utils.ParamsMapUtils

/**
 * 登录
 */
open class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    override fun onGetSM2PubK(name: String, password: String) {



    }

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