package com.app.login;

import com.app.BaseApplication;
import com.app.config.ModuleLifecycleConfig;
import com.blankj.utilcode.util.LogUtils;

public class LoginApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        LogUtils.e("App", "LoginApp onCreate()");
    }

}
