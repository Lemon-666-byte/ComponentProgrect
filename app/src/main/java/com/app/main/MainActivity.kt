package com.app.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.home.fragment.HomeFragment
import com.app.test.R
import com.blankj.utilcode.util.FragmentUtils

@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
//        MMkv.instance.putString(MMkvConfigs.UserData.lastUserInfo, "a")
//        var last = MMkv.instance.getString(MMkvConfigs.UserData.lastUserInfo)
        // 获取Fragment
        val homeFragment = HomeFragment()
        FragmentUtils.add(supportFragmentManager, homeFragment, R.id.rlContent)

    }

    override fun addListeners() {
    }
}