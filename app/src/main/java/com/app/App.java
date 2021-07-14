package com.app;

import com.app.config.ModuleLifecycleConfig;
import com.blankj.utilcode.util.LogUtils;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        LogUtils.e("BaseApplication", "App onCreate()");
    }


}
