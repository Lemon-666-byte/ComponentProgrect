package com.app.base

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.Window
import androidx.annotation.LayoutRes
import com.blankj.utilcode.util.ColorUtils


abstract class BaseDialog(context: Context) : Dialog(context) {

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun setData()
    protected abstract fun addListeners()
    open fun initPresenter() {}

    init {
        initView()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initPresenter()
        setData()
        addListeners()
    }

    fun initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE) // 去除对话框的标题
        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(ColorUtils.getColor(android.R.color.transparent))
        window?.setBackgroundDrawable(gradientDrawable) //设置对话框边框背景,必须在代码中设置对话框背景，不然对话框背景是黑色的
        this.setContentView(getLayoutId())
    }


}