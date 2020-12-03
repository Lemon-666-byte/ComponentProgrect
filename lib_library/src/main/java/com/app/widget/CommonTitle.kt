package com.app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.utils.R

/**
 * @Description:自定义title
 */
class CommonTitle(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs), View.OnClickListener {
    private var ivBack //返回图标
            : ImageView? = null
    private var tvTitle //中间标题显示控件
            : TextView? = null
    private var tvRight //右侧确定控件
            : TextView? = null
    private var mCommonTitleCallBackListener //监听接口变量
            : CommonTitleCallBackListener? = null

    /**
     * 初始化控件
     */
    private fun initView() {
        ivBack = findViewById(R.id.ivBack)
        tvTitle = findViewById(R.id.tvTitle)
        tvRight = findViewById(R.id.tvRight)
    }

    /**
     * 初始化监听
     */
    private fun initListener() {
        ivBack?.setOnClickListener(this)
        tvRight?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.ivBack) {
            mCommonTitleCallBackListener?.btnBackOnClick()
        } else if (id == R.id.tvRight) {
            mCommonTitleCallBackListener?.btnConfirmOnClick()
        }
    }

    /**
     * 设置标题
     *
     * @param resId
     */
    fun setTitle(@StringRes resId: Int) {
        tvTitle?.setText(resId)
    }

    /**
     * 设置标题
     *
     * @param text
     */
    var title: String?
        get() = if (tvTitle != null) {
            tvTitle?.text.toString()
        } else ""
        set(text) {
            tvTitle?.text = text
        }

    /**
     * 显示隐藏 返回按钮
     *
     * @param bool true 显示，false 隐藏
     */
    fun setVisibilityBack(bool: Boolean) {
        if (bool) {
            ivBack?.visibility = View.VISIBLE
        } else {
            ivBack?.visibility = View.GONE
        }
    }

    /**
     * 显示隐藏 确定按钮
     *
     * @param bool true 显示，false 隐藏
     */
    fun setVisibilityConfirm(bool: Boolean) {
        tvRight?.visibility = if (bool) View.VISIBLE else View.GONE
    }

    /**
     * 设置确定按钮文本
     *
     * @param str
     */
    fun setTextConfirm(str: String?) {
        tvRight?.text = str
    }

    /**
     * 设置确定按钮文本
     *
     * @param resId
     */
    fun setRightImg(@DrawableRes resId: Int) {
        tvRight?.setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0)
    }

    /**
     * 设置确定按钮文本
     *
     * @param resId
     */
    fun setTextConfirm(@StringRes resId: Int) {
        tvRight?.setText(resId)
    }

    /**
     * 接口的实现类设置
     *
     * @param commonTitleCallBackListener
     */
    fun setCommonTitleCallBackListener(commonTitleCallBackListener: CommonTitleCallBackListener?) {
        mCommonTitleCallBackListener = commonTitleCallBackListener
    }

    /**
     * 由每个activity自行实现此接口，实现定制的title按钮功能实现
     */
    interface CommonTitleCallBackListener {
        /**
         * 返回功能回调方法
         */
        fun btnBackOnClick()

        /**
         * 确定回调方法
         */
        fun btnConfirmOnClick()
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_header_title, this)
        initView()
        initListener()
    }
}