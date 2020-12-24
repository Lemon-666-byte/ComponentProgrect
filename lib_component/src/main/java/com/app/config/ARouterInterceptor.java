package com.app.config;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.app.utils.biz.Biz;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * 一个拦截器的例子
 *
 * @author Alex <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/1/3 11:20
 */
@Interceptor(priority = 3)
public class ARouterInterceptor implements IInterceptor {
    Context mContext;

    /**
     * The operation of this interceptor.
     *
     * @param postcard meta
     * @param callback cb
     */
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        LogUtils.e("ARouterInterceptor", "ARouterInterceptor->" + postcard.getPath());
        if (PathConfig.Home.HomeActivity.equals(postcard.getPath())) {
            // 这里的弹窗仅做举例，代码写法不具有可参考价值
            if (StringUtils.isEmpty(Biz.getInstance().uid())) {
                ToastUtils.showShort("未登录 跳转登录");
                LogUtils.e("ARouterInterceptor", "跳转登录->" + postcard.getPath());
            } else {
                callback.onContinue(postcard);
            }
//            final AlertDialog.Builder ab = new AlertDialog.Builder(ActivityUtils.getTopActivity());
//            ab.setCancelable(false);
//            ab.setTitle("温馨提醒");
//            ab.setMessage("想要跳转到Test4Activity么？(触发了\"/inter/test1\"拦截器，拦截了本次跳转)");
//            ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    callback.onContinue(postcard);
//                }
//            });
//            ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    callback.onInterrupt(null);
//                }
//            });
//            ab.setPositiveButton("加点料", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    postcard.withString("extra", "我是在拦截器中附加的参数");
//                    callback.onContinue(postcard);
//                }
//            });
//
//            ViewUtils.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    ab.create().show();
//                }
//            });
        } else {
            callback.onContinue(postcard);
        }
    }

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        LogUtils.e("ARouterInterceptor", "ARouterInterceptor->" + "init()");
        mContext = context;
    }
}
