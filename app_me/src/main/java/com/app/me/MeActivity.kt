package com.app.me

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.me.databinding.MeActivityBinding
import com.app.me.fragment.MeFragment
import com.blankj.utilcode.util.FragmentUtils

@Route(path = PathConfig.Me.MeActivity)
class MeActivity : BaseActivity() {

    private val binding: MeActivityBinding by lazy { MeActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun setData() {
        FragmentUtils.add(supportFragmentManager, MeFragment(), R.id.rlContent)
    }

    override fun addListeners() {}
}