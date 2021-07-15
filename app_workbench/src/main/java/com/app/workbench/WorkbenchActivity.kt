package com.app.workbench

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.workbench.databinding.WorkbenchActivityBinding
import com.app.workbench.fragment.WorkbenchFragment
import com.blankj.utilcode.util.FragmentUtils

@Route(path = PathConfig.WorkBench.WorkBenchActivity)

class WorkbenchActivity : BaseActivity() {
    private val binding: WorkbenchActivityBinding by lazy { WorkbenchActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root


    override fun setData() {
        FragmentUtils.add(supportFragmentManager, WorkbenchFragment(), R.id.rlContent)
    }

    override fun addListeners() {}
}