package com.app.ddjc.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseMvpActivity
import com.app.common.config.PathConfig
import com.app.ddjc.databinding.DdjcActivityBinding
import com.app.ddjc.contract.ElecTestContract
import com.app.ddjc.presenter.ElecTestPresenter


@Route(path = PathConfig.Ddjc.ElecTestActivity)
class ElecTestActivity : BaseMvpActivity<ElecTestContract.View, ElecTestPresenter>(), ElecTestContract.View {

    private val binding: DdjcActivityBinding by lazy { DdjcActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun getPresenter() = ElecTestPresenter()


    override fun setData() {

    }

    override fun addListeners() {

    }

}