package com.app;

import com.getkeepsafe.relinker.ReLinker;
import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;

public class App extends AppBase {

    @Override
    public void onCreate() {
        super.onCreate();
        initMMkv();
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

    private void initMMkv() {
        String dir = getFilesDir().getAbsolutePath() + "/mmkv";
        MMKV.initialize(dir, libName -> {
            com.blankj.utilcode.util.LogUtils.e("MMKV", "mmkv libName: " + libName);
            ReLinker.loadLibrary(App.this, libName);
        });
    }
}
