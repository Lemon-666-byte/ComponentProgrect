package com.app.workbench;

import com.app.BaseApplication;
import com.app.config.ModuleLifecycleConfig;
import com.blankj.utilcode.util.LogUtils;

public class WorkbenchApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        LogUtils.e("App", "WorkbenchApp onCreate()");
    }

}
