package com.app.login.contract

import com.app.base.mvp.BaseView
import com.app.common.bean.base.BaseBean
import com.app.common.bean.login.Login


/**
 *登录
 */
interface LoginContract {
    interface View : BaseView {
        fun handleLogin(result: Login?) {}
        fun handleGetSM2PubK(result: BaseBean<String?>?) {}
    }

    interface Presenter {
        /**
         * login
         * 登录
         * @param name 用户名称
         * @param password 用户密码
         */
        fun onGetSM2PubK(name: String, password: String)
        /**
         * 获取sm2公钥
         * @param name 用户名称
         * @param password 用户密码
         */
        fun login(name: String, password: String,mobileLogin: Boolean)


    }
}