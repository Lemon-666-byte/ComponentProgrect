package com.app.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.MMkvConfigs
import com.app.config.PathConfig
import com.app.test.R
import com.app.utils.MMkv

@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
        MMkv.instance.putString(MMkvConfigs.UserData.lastUserInfo, "a")
        var last = MMkv.instance.getString(MMkvConfigs.UserData.lastUserInfo)
    }

    override fun addListeners() {
    }
}