package com.app.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.base.BaseActivity
import com.app.common.config.PathConfig
import com.app.test.R
import com.app.test.databinding.MainActivityBinding
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.LogUtils
import com.next.easynavigation.view.EasyNavigationBar.OnTabClickListener


@Route(path = PathConfig.Main.MainActivity)
class MainActivity : BaseActivity() {

    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    override fun getLayoutId() = binding.root

    override fun initBar(initBar: Boolean) {
        super.initBar(false)
        BarUtils.setStatusBarColor(this,ColorUtils.getColor(R.color.colorBlack000))
        BarUtils.setStatusBarLightMode(this, true)
    }

    override fun savedInstanceState(savedInstanceState: Bundle?) {
        super.savedInstanceState(savedInstanceState)

    }
    override fun setData() {
        initFragments()
//        LiveEventBus.get(EventConfigs.UserData.userInfo, String::class.java)
//            .observe(this, { t -> LogUtils.e("aaaaaa->$t") })
//        ThreadUtils.executeByIo(object : ThreadUtils.SimpleTask<String>() {
//            override fun doInBackground(): String {
//                val task = Task()
//                task.taskId = "123456"
//                DBUtils.getInstance().db.taskDao().insert(task)
//                return task.taskId
//            }
//
//            override fun onSuccess(result: String?) {
//                LogUtils.e(result)
//            }
//        })


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
     * 加载需要显示的内容
     */
    private fun initFragments() {
        val fragments = ArrayList<Fragment>()
        val homeFragment =
            ARouter.getInstance().build(PathConfig.Home.HomeFragment).navigation() as Fragment
        val workBenchFragment = ARouter.getInstance().build(PathConfig.WorkBench.WorkBenchFragment)
            .navigation() as Fragment
        val meFragment = ARouter.getInstance().build(PathConfig.Me.MeFragment)
            .navigation() as Fragment
        val tabText: Array<String> = arrayOf("首页", "工作台", "我")
        //未选中icon
        val normalIcon: IntArray = intArrayOf(
            R.mipmap.ic_home,
            R.mipmap.ic_gzt,
            R.mipmap.ic_me,
        )
        //选中时icon
        val selectIcon: IntArray = intArrayOf(
            R.mipmap.ic_home,
            R.mipmap.ic_gzt,
            R.mipmap.ic_me,
        )
        fragments.add(homeFragment)
        fragments.add(workBenchFragment)
        fragments.add(meFragment)
        binding.navigationBar.titleItems(tabText)
            .normalIconItems(normalIcon)
            .selectIconItems(selectIcon)
            .fragmentList(fragments)
            .normalTextColor(ColorUtils.getColor(R.color.colorWhite))
            .selectTextColor(ColorUtils.getColor(R.color.colorBlue))
            .tabTextSize(10) //                .anim(Anim.Pulse)
            .navigationHeight(45) //导航栏高度
            .iconSize(20f) //Tab图标大小
            .canScroll(false)
            .smoothScroll(true)
            .lineColor(ColorUtils.getColor(R.color.colorD5D5D5))
            .lineHeight(1)
            .navigationBackground(ColorUtils.getColor(R.color.color979797))
            .fragmentManager(supportFragmentManager)
            .build()
        val viewPager: ViewPager = binding.navigationBar.viewPager
        viewPager.offscreenPageLimit = fragments.size

        binding.navigationBar.onTabClickListener = object : OnTabClickListener {
            override fun onTabSelectEvent(view: View?, position: Int): Boolean {
                LogUtils.e("navigation", "选择了$position")
//                if (position == 2) {
//                    ARouter.getInstance().build(PathConfig.Me.MeActivity).navigation()
//                    return true
//                }
                return false
            }

            override fun onTabReSelectEvent(view: View?, position: Int): Boolean {
                LogUtils.e("navigation", "重复点击了$position")
                return true
            }

        }
    }

}