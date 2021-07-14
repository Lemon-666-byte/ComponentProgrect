package com.app.home;

import android.app.Application;

import com.app.BaseApplication;
import com.blankj.utilcode.util.LogUtils;

public class HomeApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        LogUtils.e("HomeApp", "HomeApp onCreate()");
    }

    @Override
    public void initModuleApp(Application application) {
        LogUtils.e("HomeApp", "HomeApp initModuleApp()");
    }

}
