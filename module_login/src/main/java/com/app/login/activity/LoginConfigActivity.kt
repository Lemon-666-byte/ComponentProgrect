package com.app.login.activity

import android.graphics.Color
import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.common.config.Constants
import com.app.common.config.MMkvConfigs
import com.app.common.config.PathConfig
import com.app.login.databinding.LoginConfigActivityBinding
import com.app.utils.MMkvUtils
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * 软件配置页面
 */
@Route(path = PathConfig.Login.LoginConfigActivity)
class LoginConfigActivity : BaseActivity() {

    private val binding by lazy { LoginConfigActivityBinding.inflate(layoutInflater) }


    override fun getLayoutId() = binding.root


    override fun setData() {
        val serverIp: String = MMkvUtils.getString(MMkvConfigs.BaseUrl.serverIp)
        val serverPort: String = MMkvUtils.getString(MMkvConfigs.BaseUrl.serverPort)

        val tldz = MMkvUtils.getString(MMkvConfigs.BaseUrl.tldz)
        if (tldz.isEmpty()) {
            MMkvUtils.putString(MMkvConfigs.BaseUrl.tldz, Constants.BaseUrl.tldz)
        }

        if (serverIp.isNotEmpty()) {
            binding.etServerIp.setText(serverIp)
        }

        if (serverPort.isNotEmpty()) {
            binding.etServerPort.setText(serverPort)
        }
    }

    override fun addListeners() {
        binding.btnOk.setOnClickListener {
            val serverIp: String = binding.etServerIp.text.toString()
            val serverPort: String = binding.etServerPort.text.toString()
            val tldz: String = binding.etTldz.text.toString()


            if (serverIp.isEmpty()) {
                ToastUtils.showShort("请输入ip地址!")
                return@setOnClickListener
            }

            if (!RegexUtils.isMatch(Constants.Regex.url, serverIp)) {
                binding.etServerIp.setTextColor(Color.RED)
                ToastUtils.showLong("IP地址不合法！")
                return@setOnClickListener
            }
            if (serverPort.isEmpty()) {
                ToastUtils.showShort("请输入服务端口!")
                return@setOnClickListener
            }
            if (tldz.isEmpty()) {
                ToastUtils.showShort("请输入推流地址!")
                return@setOnClickListener
            }
            MMkvUtils.putString(MMkvConfigs.BaseUrl.serverIp, serverIp)
            MMkvUtils.putString(MMkvConfigs.BaseUrl.serverPort, serverPort)
            MMkvUtils.putString(MMkvConfigs.BaseUrl.tldz, tldz)
            finish()
        }
    }


}