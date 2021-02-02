package com.app.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.app.utils.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * dialog 基类
 */
abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {
    protected val TAG = javaClass.simpleName

    var thisView: View? = null

    open fun getBundle(bundle: Bundle) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDialogStyle()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 设置圆角需要
        dialog?.let {
            it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setCanceledOnTouchOutside(canceledOnTouchOutside())
        }
        isCancelable = cancelable()
        thisView = LayoutInflater.from(context).inflate(getLayoutId(), null)
        return thisView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { getBundle(it) }
        initPresenter()
        setData()
        addListeners()
    }

    /**
     * 显示Dialog
     */
    fun show(fragmentManager: FragmentManager) {
        val transaction = fragmentManager.beginTransaction()
        val pre = fragmentManager.findFragmentByTag(TAG)
        if (pre != null) {
            transaction.remove(pre)
        }
        try {
            show(transaction, TAG)
        } catch (e: IllegalStateException) {
            //  容错处理,不做操作
        }
    }

    /**
     * 显示Dialog
     */
    fun show(activity: FragmentActivity) {
        show(activity.supportFragmentManager)
    }

    /**
     * 避免莫名其妙的空指针
     * onSaveInstance后commit无法提交
     */
    override fun dismiss() {
        if (fragmentManager == null) {
            return
        }
        dismissAllowingStateLoss()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun setData()
    protected abstract fun addListeners()
    open fun initPresenter() {}

    /**
     * override
     * 配置对话框风格  背景不再变黑
     */
    protected fun setDialogStyle() {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomDialog);
    }

    /**
     * override
     * 配置点击对话框外部是否消失
     */
    open fun canceledOnTouchOutside(): Boolean = true

    /**
     * override
     * 配置返回键是否可以关闭对话框
     */
    open fun cancelable(): Boolean = true
}