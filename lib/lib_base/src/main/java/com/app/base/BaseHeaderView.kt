package com.app.base

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.AdaptScreenUtils

/**
 * header
 */
abstract class BaseHeaderView(context: Context) : LinearLayout(context), View.OnClickListener {

    /**
     * 页面标签
     */
    protected val TAG = javaClass.simpleName
    protected var thisView: View? = null
    protected abstract fun getLayoutId(): Int
    protected abstract fun setData()
    protected abstract fun addListeners()
    open fun initPresenter() {}
    override fun onClick(v: View) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initPresenter()
        setData()
        addListeners()
    }

    init {
        thisView = View.inflate(getContext(), getLayoutId(), null)
        this.addView(thisView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

    }
}