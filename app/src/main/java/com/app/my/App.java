package com.app.my;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.tencent.smtt.sdk.QbSdk;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        initX5();
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
}
