package com.app.common.bean.login

data class Login(
    val id: String,
    val loginName: String,
    val mobileLogin: Boolean,
    val name: String,
    val sessionid: String
)