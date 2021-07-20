package com.app.ddjc;

import com.app.BaseApplication;
import com.app.config.ModuleLifecycleConfig;
import com.blankj.utilcode.util.LogUtils;

/**
 * 带电检测
 */
public class ElecTestApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        LogUtils.e("App", "ElecTestApp onCreate()");
    }

}
