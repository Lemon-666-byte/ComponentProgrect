package com.app.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import autodispose2.AutoDisposeConverter
import com.app.base.mvp.BaseView
import com.app.http.RxLifecycleUtils
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.SizeUtils

/**
 * @author chenxz
 * @date 2018/11/19
 * @desc BaseFragment
 */
abstract class BaseFragment : Fragment(), BaseView {
    val classTag = this.javaClass.simpleName
    var rootView: View? = null
    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyLoad()
            isLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

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

    /**
     * 加载布局
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    open fun getBundle(bundle: Bundle) {}

    open fun initPresenter() {}

    protected abstract fun setData()

    protected abstract fun addListeners()

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract fun lazyLoad()

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected open fun stopLoad() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayoutId(), null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        arguments?.let { getBundle(it) }
        initPresenter()
        setData()
        addListeners()
    }

    private fun initView() {
    }

    protected open fun enterPager(actClass: Class<*>) {
        activity?.let {
            val intent = Intent()
            intent.setClass(it, actClass)
            ActivityUtils.startActivity(intent)
        }

    }

    protected open fun enterPagerForResult(actClass: Class<*>, resultCode: Int) {
        activity?.let {
            val intent = Intent()
            intent.setClass(it, actClass)
            ActivityUtils.startActivityForResult(it, intent, resultCode)
        }

    }

    protected open fun enterPager(actClass: Class<*>, bundle: Bundle) {
        activity?.let {
            val intent = Intent()
            intent.setClass(it, actClass)
            intent.putExtras(bundle)
            ActivityUtils.startActivity(intent)
        }

    }

    protected open fun enterPagerForResult(actClass: Class<*>, bundle: Bundle, resultCode: Int) {
        activity?.let {
            val intent = Intent()
            intent.setClass(it, actClass)
            intent.putExtras(bundle)
            ActivityUtils.startActivityForResult(this, intent, resultCode)
        }

    }

    override fun showLoading(loadingText: String) {

    }

    override fun hideLoading() {

    }

    override fun showErrorView(error: String) {

    }

    override fun onError(throwable: Throwable?) {

    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    override fun <T> bindAutoDispose(): AutoDisposeConverter<T> {
        return RxLifecycleUtils.bindLifecycle(this)
    }
}