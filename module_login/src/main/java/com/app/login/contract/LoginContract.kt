package com.app.login.contract

import com.app.base.mvp.BaseView
import com.app.bean.login.Login
import com.app.net.bean.BaseBean


/**
 *创建军团
 */
interface LoginContract {
    interface View : BaseView {
        fun handleLogin(result: BaseBean<Login?>?) {}

    }

    interface Presenter {
        /**
         * login
         * 登录
         * @param name 用户名称
         * @param password 用户密码
         */
        fun login(name: String, password: String)


    }
}