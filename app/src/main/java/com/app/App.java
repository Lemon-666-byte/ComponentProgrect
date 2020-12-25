package com.app;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        LogUtils.e("BaseApplication", "App onCreate()");
    }

    @Override
    public void initModuleApp(Application application) {

    }


}
