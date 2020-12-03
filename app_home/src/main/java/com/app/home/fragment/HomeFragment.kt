package com.app.home.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.config.PathConfig
import com.app.home.R

@Route(path = PathConfig.Main.HomeFragment)
class HomeFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.home_fragment

    override fun setData() {
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}