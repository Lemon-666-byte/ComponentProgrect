package com.app.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.EventConfigs
import com.app.config.PathConfig
import com.app.test.R
import com.app.test.databinding.MainActivityBinding
import com.blankj.utilcode.util.LogUtils
import com.jeremyliao.liveeventbus.LiveEventBus


@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {

    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun initBar(initBar: Boolean) {
        super.initBar(false)
    }

    override fun setData() {
//        val homeFragment = ARouter.getInstance().build(PathConfig.Home.HomeFragment).navigation() as Fragment
//        FragmentUtils.add(supportFragmentManager, homeFragment, R.id.rlContent)
        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).observe(this, { t -> LogUtils.e("aaaaaa->$t") })
//        val testDialog: TestDialog = TestDialog()
//        testDialog.show(supportFragmentManager)
//        showTwo()
    }


    override fun addListeners() {
//        tvGo.setOnClickListener {
//            LogUtils.e("ARouterInterceptor", "->" + "tvGo")
//            ARouter.getInstance().build(PathConfig.Home.HomeActivity).navigation()

//            val testUriMix = Uri.parse("arouter://m.aliyun.com/home/HomeActivity")
//            ARouter.getInstance().build(testUriMix)
//                    .withString("key1", "value1")
//                    .navigation()
//        }
    }

    /**
     * 两个按钮的 dialog
     */
    private fun showTwo() {
        val builder = AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("最普通dialog")
                .setMessage("我是最简单的dialog").setPositiveButton("确定（积极）", DialogInterface.OnClickListener { dialogInterface, i -> //ToDo: 你想做的事情
                    Toast.makeText(this@MainActivity, "确定按钮", Toast.LENGTH_LONG).show()
                }).setNegativeButton("取消（消极）", DialogInterface.OnClickListener { dialogInterface, i -> //ToDo: 你想做的事情
                    Toast.makeText(this@MainActivity, "关闭按钮", Toast.LENGTH_LONG).show()
                    dialogInterface.dismiss()
                })
        builder.create().show()
    }
}