package com.app.lunch

import android.annotation.SuppressLint
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.http.RxSchedulers
import com.app.test.R
import com.app.test.databinding.LunchActivityBinding
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.LogUtils
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * 软件启动页面
 */
class LunchActivity : BaseActivity() {

    private val binding by lazy { LunchActivityBinding.inflate(layoutInflater) }

    override fun initBar(initBar: Boolean) {
        super.initBar(false)
        BarUtils.transparentStatusBar(this)
    }

    override fun getLayoutId() = binding.root

    var delaySubscribe: Disposable? = null

    @SuppressLint("AutoDispose")
    override fun setData() {
        delaySubscribe = Observable.timer(2, TimeUnit.SECONDS)
                .compose(RxSchedulers.applySchedulers())
                .subscribe { aLong -> toMain() }
    }

    override fun addListeners() {

    }


    override fun onDestroy() {
        super.onDestroy()
        delaySubscribe?.dispose()
    }

    private fun toMain() {

        ARouter.getInstance().build(PathConfig.Main.MainActivity).navigation(this, object : NavigationCallback {
            override fun onFound(postcard: Postcard?) {
                LogUtils.e(classTag, "onFound()")
            }

            override fun onLost(postcard: Postcard?) {
                LogUtils.e(classTag, "onLost()")
            }

            override fun onArrival(postcard: Postcard?) {
                LogUtils.e(classTag, "onArrival()")
                finish()
            }

            override fun onInterrupt(postcard: Postcard?) {
                LogUtils.e(classTag, "onInterrupt()")
            }

        })

    }
}