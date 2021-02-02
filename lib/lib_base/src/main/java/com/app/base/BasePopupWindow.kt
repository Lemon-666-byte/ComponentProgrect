package com.app.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow

/**
 * PopupWindow 基类
 */
abstract class BasePopupWindow(context: Context?) : PopupWindow(context) {
    protected val TAG = javaClass.simpleName
    protected var thisView: View
    protected abstract val layoutId: Int
    protected abstract fun init()
    protected abstract fun initPresenter()
    protected abstract fun setData()
    protected abstract fun setListener()

    /**
     * override
     * 配置点击对话框外部是否消失
     */
    protected val canceledOnTouchOutside: Boolean
        protected get() = false

    /**
     * override
     * 配置返回键是否可以关闭对话框
     */
    protected val cancelable: Boolean
        protected get() = true

    init {
        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
        isOutsideTouchable = true
        isFocusable = true
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        thisView = LayoutInflater.from(context).inflate(layoutId, null, false)
        init()
        initPresenter()
        setData()
        setListener()
        contentView = thisView
    }
}