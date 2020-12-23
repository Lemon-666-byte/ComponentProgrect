package com.app.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.TypedValue
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.my.TestDialog
import com.app.test.R
import com.blankj.utilcode.util.AdaptScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ToastUtils


@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
//        val homeFragment = ARouter.getInstance().build(PathConfig.Home.HomeFragment).navigation() as Fragment
//        FragmentUtils.add(supportFragmentManager, homeFragment, R.id.rlContent)
//
//        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java).observe(this, { t -> LogUtils.e("aaaaaa->$t") })
        ToastUtils.showShort("bbbbbb")

//        val testDialog: TestDialog = TestDialog()
//        testDialog.show(supportFragmentManager)
//        showTwo()
       val s= SizeUtils.applyDimension(20f,TypedValue.COMPLEX_UNIT_PT)

    }

    override fun addListeners() {
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