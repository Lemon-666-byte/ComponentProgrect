package com.app.lunch

import android.annotation.SuppressLint
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.http.RxSchedulers
import com.app.test.R
import com.blankj.utilcode.util.BarUtils
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * 软件启动页面
 */
class LunchActivity : BaseActivity() {
    override fun initBar(initBar: Boolean) {
        super.initBar(false)
        BarUtils.transparentStatusBar(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.lunch_activity
    }

    var delaySubscribe: Disposable? = null

    @SuppressLint("AutoDispose")
    override fun setData() {
        delaySubscribe = Observable.timer(2, TimeUnit.SECONDS)
                .compose(RxSchedulers.applySchedulers())
                .subscribe { aLong -> toMain() }
    }

    override fun addListeners() {

    }

    override fun onPause() {
        super.onPause()
        delaySubscribe?.dispose()
    }

    private fun toMain() {
        ARouter.getInstance().build(PathConfig.Main.MainActivity).navigation()
        finish()
    }
}