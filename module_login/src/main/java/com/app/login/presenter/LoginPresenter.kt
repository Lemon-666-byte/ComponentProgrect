package com.app.login.presenter

import com.app.base.mvp.BasePresenter
import com.app.bean.login.Login
import com.app.login.contract.LoginContract
import com.app.net.NetRequestListener
import com.app.net.bean.BaseBean
import com.app.utils.net.ApiServiceUtils
import com.app.utils.net.ParamsMapUtils

/**
 * 登录
 */
open class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(name: String, password: String) {
        getView()?.showLoading()
        val params = ParamsMapUtils.commonParams
        params["name"] = name
        params["password"] = password

        requestNetwork(ApiServiceUtils.apiLogin.login(params), object :
            NetRequestListener<BaseBean<Login?>?> {
            override fun onSuccess(result: BaseBean<Login?>?) {
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