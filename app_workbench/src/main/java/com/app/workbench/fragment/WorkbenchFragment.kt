package com.app.workbench.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseFragment
import com.app.common.config.PathConfig
import com.app.workbench.databinding.WorkbenchFragmentBinding

@Route(path = PathConfig.WorkBench.WorkBenchFragment)
class WorkbenchFragment : BaseFragment() {

    private val binding: WorkbenchFragmentBinding by lazy { WorkbenchFragmentBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun setData() {
//        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).post("bbb")
    }

    override fun addListeners() {
    }

    override fun lazyLoad() {
    }
}