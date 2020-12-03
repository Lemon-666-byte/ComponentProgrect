package com.app.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.test.R

@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
    }

    override fun addListeners() {
    }
}