package com.app.home.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.config.PathConfig
import com.app.home.R
import com.app.home.databinding.HomeFragmentBinding

@Route(path = PathConfig.Home.HomeFragment)
class HomeFragment : BaseFragment() {

    private val binding: HomeFragmentBinding by lazy { HomeFragmentBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun setData() {
//        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).post("bbb")
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}