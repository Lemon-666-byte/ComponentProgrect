package com.app.login.activity

import android.annotation.SuppressLint
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseMvpActivity
import com.app.common.bean.login.Login
import com.app.common.config.Constants
import com.app.common.config.MMkvConfigs
import com.app.common.config.PathConfig
import com.app.common.utils.biz.Biz
import com.app.login.R
import com.app.login.contract.LoginContract
import com.app.login.databinding.LoginActivityBinding
import com.app.login.presenter.LoginPresenter
import com.app.net.RxSchedulers
import com.app.utils.MMkvUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit


@Route(path = PathConfig.Login.LoginActivity)
class LoginActivity : BaseMvpActivity<LoginContract.View, LoginPresenter>(), LoginContract.View {

    private val binding: LoginActivityBinding by lazy { LoginActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun getPresenter() = LoginPresenter()


    var delaySubscribe: Disposable? = null


    override fun setData() {
        val isChecked = MMkvUtils.getBoolean(MMkvConfigs.User.remember)
        binding.cbRemember.isChecked = isChecked
        if (isChecked) {
            binding.etUserName.setText(MMkvUtils.getString(MMkvConfigs.User.userName))
            binding.etPassword.setText(MMkvUtils.getString(MMkvConfigs.User.password))
        }


    }

    @SuppressLint("AutoDispose")
    override fun addListeners() {
        binding.btnLogin.setOnClickListener {
            val serverIp = MMkvUtils.getString(MMkvConfigs.BaseUrl.serverIp)
            val serverPort = MMkvUtils.getString(MMkvConfigs.BaseUrl.serverPort)
            val tldz = MMkvUtils.getString(MMkvConfigs.BaseUrl.tldz)
            if (tldz.isEmpty()) {
                MMkvUtils.putString(MMkvConfigs.BaseUrl.tldz, Constants.BaseUrl.tldz)
            }
            if (serverIp.isEmpty() || serverPort.isEmpty()) {
                delaySubscribe = Observable.timer(2, TimeUnit.SECONDS)
                    .compose(RxSchedulers.applySchedulers())
                    .subscribe { aLong ->
                        ARouter.getInstance().build(PathConfig.Login.LoginConfigActivity)
                            .navigation()
                    }
                return@setOnClickListener
            }

            val userName = binding.etUserName.text.toString()
            val password = binding.etPassword.text.toString()

            when {
                userName.isEmpty() -> {
                    ToastUtils.showShort("用户名未填写!")
                }
                password.isEmpty() -> {
                    ToastUtils.showShort("用户密码未填写!")
                }
                else -> {
                    MMkvUtils.putBoolean(MMkvConfigs.User.remember, binding.cbRemember.isChecked)
                    if (binding.cbRemember.isChecked) {
                        MMkvUtils.putString(MMkvConfigs.User.userName, userName)
                        MMkvUtils.putString(MMkvConfigs.User.password, password)
                    } else {
                        MMkvUtils.putString(MMkvConfigs.User.userName, "")
                        MMkvUtils.putString(MMkvConfigs.User.password, "")
                    }

                    mPresenter?.login(userName, password, true)
                }
            }
        }

        binding.ivSetting.setOnClickListener {
            ARouter.getInstance().build(PathConfig.Login.LoginConfigActivity).navigation()
        }
    }

    override fun handleLogin(result: Login?) {
        result?.let {
            Biz.instance.sessionid = result.sessionid
            ARouter.getInstance().build(PathConfig.Main.MainActivity).navigation()
            finish()
        } ?: ToastUtils.showShort(getString(R.string.no_net_error))
//        result?.let {
//            ARouter.getInstance().build(PathConfig.Main.MainActivity).navigation()
//        } ?: let {
//            ToastUtils.showShort(getString(R.string.no_net_error))
//        }
    }


    override fun onDestroy() {
        super.onDestroy()
        delaySubscribe?.dispose()
    }
}