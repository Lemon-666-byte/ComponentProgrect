package com.app;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.app.test.BuildConfig;
import com.blankj.utilcode.util.Utils;
import com.getkeepsafe.relinker.ReLinker;
import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        initARouter();
        initMMkv();
        initX5();
    }

    /**
     * 初始化 路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    private void initX5() {
        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback() {

            @Override
            public void onCoreInitFinished() {
                com.blankj.utilcode.util.LogUtils.e("x5 onCoreInitFinished()");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                com.blankj.utilcode.util.LogUtils.e("x5->" + b);
            }
        };
        QbSdk.initX5Environment(this, callback);
    }

    private void initMMkv() {
        String dir = getFilesDir().getAbsolutePath() + "/mmkv";
        MMKV.initialize(dir, libName -> {
            com.blankj.utilcode.util.LogUtils.e("MMKV", "mmkv libName: " + libName);
            ReLinker.loadLibrary(App.this, libName);
        });
    }
}
