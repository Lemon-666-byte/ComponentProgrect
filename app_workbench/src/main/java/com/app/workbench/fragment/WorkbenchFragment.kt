package com.app.workbench.fragment

import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseFragment
import com.app.common.config.Constants
import com.app.common.config.PathConfig
import com.app.workbench.R
import com.app.workbench.adapter.WorkbenchItemAdapter
import com.app.workbench.bean.WorkbenchItem
import com.app.workbench.databinding.WorkbenchFragmentBinding
import com.blankj.utilcode.util.LogUtils

@Route(path = PathConfig.WorkBench.WorkBenchFragment)
class WorkbenchFragment : BaseFragment() {

    private val binding: WorkbenchFragmentBinding by lazy {
        WorkbenchFragmentBinding.inflate(layoutInflater)
    }

    override fun getLayoutId() = binding.root

    private val workbenchItemAdapter: WorkbenchItemAdapter by lazy {
        val workbenchItemAdapter = WorkbenchItemAdapter()
        binding.rvWorkBench.layoutManager = GridLayoutManager(context, 3)
        workbenchItemAdapter
    }

    private var workbenchList = mutableListOf(
        WorkbenchItem(Constants.Workbench.xsgl, R.mipmap.workbench_xsgl),
        WorkbenchItem(Constants.Workbench.qxgl, R.mipmap.workbench_qxgl),
        WorkbenchItem(Constants.Workbench.yhgl, R.mipmap.workbench_yhgl),
        WorkbenchItem(Constants.Workbench.bdgl, R.mipmap.workbench_bdgl),
        WorkbenchItem(Constants.Workbench.jxjsy, R.mipmap.workbench_jxjsy),
        WorkbenchItem(Constants.Workbench.gzqx, R.mipmap.workbench_gzqx),
        WorkbenchItem(Constants.Workbench.ddjc, R.mipmap.workbench_jxjsy),
    )

    override fun setData() {
        binding.rvWorkBench.adapter = workbenchItemAdapter
        workbenchItemAdapter.setNewInstance(workbenchList)
    }

    override fun addListeners() {
        workbenchItemAdapter.setOnItemClickListener { adapter, view, position ->
            val item = workbenchItemAdapter.getItem(position)
            when (item.name) {
                Constants.Workbench.xsgl -> {
                    // 巡视管理
                    LogUtils.e(classTag, "巡视管理")
                }
                Constants.Workbench.qxgl -> {
                    // 缺陷管理
                    LogUtils.e(classTag, "缺陷管理")
                }
                Constants.Workbench.yhgl -> {
                    // 隐患管理
                    LogUtils.e(classTag, "隐患管理")
                }
                Constants.Workbench.bdgl -> {
                    // 保电管理
                    LogUtils.e(classTag, "保电管理")
                }
                Constants.Workbench.jxjsy -> {
                    // 检修及实验
                    LogUtils.e(classTag, "检修及实验")
                }
                Constants.Workbench.gzqx -> {
                    // 故障检修
                    LogUtils.e(classTag, "故障检修")
                }
                Constants.Workbench.ddjc -> {
                    // 带电检测
                    LogUtils.e(classTag, "带电检测")
                    ARouter.getInstance().build(PathConfig.Ddjc.ElecTestActivity).navigation()
                }
            }
        }
    }

    override fun lazyLoad() {
    }
}