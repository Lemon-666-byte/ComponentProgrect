package com.app.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.app.widget.CommonTitle
import com.blankj.utilcode.util.*

abstract class BaseActivity : AppCompatActivity(), CommonTitle.CommonTitleCallBackListener {
    protected val classTag = this.javaClass.simpleName

    protected val thisContext: Context by lazy {
        this
    }
    protected val thisActivity: Activity by lazy {
        this
    }
    private var statusBar = true

    /**
     * 公用头
     */
    private var commonTitle: CommonTitle? = null

    protected abstract fun getLayoutId(): View

    open fun getBundle(bundle: Bundle) {}

    open fun initPresenter() {}

    protected abstract fun setData()

    protected abstract fun addListeners()

    protected val loadingView: View by lazy {
        layoutInflater.inflate(R.layout.view_loading_view, null, false)
    }
    protected val errorView: View by lazy {
        layoutInflater.inflate(R.layout.view_error_view, null, false)
    }

    protected open fun getEmptyView(@DrawableRes resId: Int = R.drawable.error_icon,
                                    emptyText: String = getString(R.string.no_data_text),
                                    height: Float = 0.0f): View {
        val emptyView = layoutInflater.inflate(R.layout.view_no_more_view, null, false)
        emptyView.findViewById<ImageView>(R.id.ivNoDateView).setImageResource(resId)
        emptyView.findViewById<TextView>(R.id.tvMessage).text = emptyText
        if (height > 0) {
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(height))
            emptyView.layoutParams = layoutParams
        }
        return emptyView
    }

    protected open fun initBar(initBar: Boolean) {
        this.statusBar = initBar
        if (statusBar) {
            BarUtils.setStatusBarLightMode(this, true)
            BarUtils.setStatusBarColor(this, ColorUtils.getColor(R.color.colorWhite))
            commonTitle?.let {
                BarUtils.addMarginTopEqualStatusBarHeight(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initBar(statusBar)
        intent.extras?.let { getBundle(it) }
        initPresenter()
        setData()
        addListeners()
    }

    private fun initView() {
        ARouter.getInstance().inject(this)
        commonTitle = findViewById(R.id.mCommonTitle)
        commonTitle?.let {
            it.setCommonTitleCallBackListener(this)
            it.title = this.title.toString()
        }
    }

    override fun btnBackOnClick() {
        finish()
    }

    override fun btnConfirmOnClick() {
    }

    protected open fun enterPager(actClass: Class<*>) {
        val intent = Intent()
        intent.setClass(this, actClass)
        ActivityUtils.startActivity(intent)
    }

    protected open fun enterPagerForResult(actClass: Class<*>, resultCode: Int) {
        val intent = Intent()
        intent.setClass(this, actClass)
        ActivityUtils.startActivityForResult(this, intent, resultCode)
    }

    protected open fun enterPager(actClass: Class<*>, bundle: Bundle) {
        val intent = Intent()
        intent.setClass(this, actClass)
        intent.putExtras(bundle)
        ActivityUtils.startActivity(intent)
    }

    protected open fun enterPagerForResult(actClass: Class<*>, bundle: Bundle, resultCode: Int) {
        val intent = Intent()
        intent.setClass(this, actClass)
        intent.putExtras(bundle)
        ActivityUtils.startActivityForResult(this, intent, resultCode)
    }

    fun getCommonTitle(): CommonTitle {
        return this.commonTitle!!
    }

    override fun getResources(): Resources {
        return AdaptScreenUtils.adaptWidth(super.getResources(), BaseConfigs.Screen.designWidth)
    }
}