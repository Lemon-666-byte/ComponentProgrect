package com.app.me.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.common.config.PathConfig
import com.app.me.databinding.MeFragmentBinding

@Route(path = PathConfig.Me.MeFragment)
class MeFragment : BaseFragment() {

    private val binding: MeFragmentBinding by lazy { MeFragmentBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun setData() {
//        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).post("bbb")
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}