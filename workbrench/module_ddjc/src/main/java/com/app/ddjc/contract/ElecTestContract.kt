package com.app.ddjc.contract

import com.app.base.mvp.BaseView
import com.app.common.bean.login.Login


/**
 *登录
 */
interface ElecTestContract {
    interface View : BaseView {
        fun handleLogin(result: Login?) {}

    }

    interface Presenter {

        /**
         * 获取sm2公钥
         * @param name 用户名称
         * @param password 用户密码
         */
        fun login(name: String, password: String,mobileLogin: Boolean)


    }
}