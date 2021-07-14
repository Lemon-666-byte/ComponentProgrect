package com.app.home;

import com.app.BaseApplication;
import com.app.config.ModuleLifecycleConfig;
import com.blankj.utilcode.util.LogUtils;

public class HomeApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        LogUtils.e("HomeApp", "HomeApp onCreate()");
    }

}
