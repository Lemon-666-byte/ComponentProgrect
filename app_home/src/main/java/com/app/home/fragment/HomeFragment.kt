package com.app.home.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.config.EventConfigs
import com.app.config.PathConfig
import com.app.home.R
import com.jeremyliao.liveeventbus.LiveEventBus

@Route(path = PathConfig.Home.HomeFragment)
class HomeFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.home_fragment

    override fun setData() {
        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).post("bbb")
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}