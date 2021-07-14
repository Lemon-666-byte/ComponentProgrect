package com.app;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.base.BuildConfig;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;

/**
 * @author
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
