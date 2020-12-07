package com.app.main

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.config.EventConfigs
import com.app.config.PathConfig
import com.app.test.R
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.LogUtils
import com.jeremyliao.liveeventbus.LiveEventBus

@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
        val homeFragment = ARouter.getInstance().build(PathConfig.Home.HomeFragment).navigation() as Fragment
        FragmentUtils.add(supportFragmentManager, homeFragment, R.id.rlContent)

        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).observe(this, { t -> LogUtils.e("aaaaaa->$t") })
    }

    override fun addListeners() {
    }
}