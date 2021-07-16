package com.app.login.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.base.BaseMvpActivity
import com.app.bean.login.Login
import com.app.config.MMkvConfigs
import com.app.config.PathConfig
import com.app.login.R
import com.app.login.contract.LoginContract
import com.app.login.databinding.LoginActivityBinding
import com.app.login.presenter.LoginPresenter
import com.app.net.bean.BaseBean
import com.app.utils.MMkvUtils
import com.blankj.utilcode.util.ToastUtils


@Route(path = PathConfig.Login.LoginActivity)
class LoginActivity : BaseMvpActivity<LoginContract.View, LoginPresenter>(), LoginContract.View {

    private val binding: LoginActivityBinding by lazy { LoginActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun getPresenter() = LoginPresenter()

    override fun setData() {

    }

    override fun addListeners() {
        binding.btnLogin.setOnClickListener {
            mPresenter?.login("abc", "123")
        }
    }

    override fun handleLogin(result: BaseBean<Login?>?) {
        if (result == null) {
            ToastUtils.showShort(getString(R.string.no_net_error))
        } else {
            if (result.isSuccess()) {
                result.data?.let {
                    MMkvUtils.instance.putString(MMkvConfigs.Login.loginName,it.name)
//                    finish()
                }
            }
        }
    }
}