package com.app.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.config.PathConfig
import com.app.home.fragment.HomeFragment
import com.app.test.R
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ViewUtils

@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.main_activity

    override fun setData() {
//        MMkv.instance.putString(MMkvConfigs.UserData.lastUserInfo, "a")
//        var last = MMkv.instance.getString(MMkvConfigs.UserData.lastUserInfo)
        // 获取Fragment
//        val homeFragment = HomeFragment()
//        FragmentUtils.add(supportFragmentManager, homeFragment, R.id.rlContent)

        ViewUtils.runOnUiThreadDelayed({
//            var fragment = ARouter.getInstance().build(PathConfig.Main.HomeFragment).navigation()
//            var fragment1 = ARouter.getInstance().build(PathConfig.Main.HomeFragment1).navigation()
//            LogUtils.e(classTag, "" + fragment + "  " + fragment1)

            ARouter.getInstance().build(PathConfig.Main.HomeActivity).navigation()
//            Toast.makeText(this, "Fragment->$fragment", Toast.LENGTH_SHORT).show()
        }, 2000)

    }

    override fun addListeners() {
    }
}