package com.app.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.config.PathConfig
import com.app.home.R

@Route(path = PathConfig.Main.HomeFragment1)
class HomeFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.home_fragment

    override fun setData() {
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}