package com.app.widget.dialog

import android.os.Bundle
import android.view.View
import com.app.base.BaseDialogFragment
import com.app.utils.R

/**
 * @date 2018-06-25
 * @Description:自定义dialog
 */
class LoadingDialog : BaseDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            isCancelable = bundle.getBoolean("isCancel")
        }
    }

    override fun onStart() {
        super.onStart()
        setScreenBrightness(0.0f)
    }

    /**
     * 设置屏幕亮度值
     *
     * @param dimAmount 代表黑暗数量，也就是昏暗的多少，设置为0则代表完全明亮。 范围是0.0到1.0
     */
    private fun setScreenBrightness(dimAmount: Float) {
        val window = dialog?.window!!
        val windowParams = window.attributes
        windowParams.dimAmount = dimAmount
        window.attributes = windowParams
    }

    override fun getLayoutId(): Int {
        return R.layout.main_dialog_loading
    }

    override fun setData() {
        thisView?.findViewById<View>(R.id.llLoading)?.visibility = View.VISIBLE
    }

    override fun addListeners() {}

    companion object {
        fun newInstance(isCancel: Boolean): LoadingDialog {
            val bundle = Bundle()
            bundle.putBoolean("isCancel", isCancel)
            val loadingDialogFragment = LoadingDialog()
            loadingDialogFragment.arguments = bundle
            return loadingDialogFragment
        }

        fun newInstance(): LoadingDialog {
            return LoadingDialog()
        }
    }
}