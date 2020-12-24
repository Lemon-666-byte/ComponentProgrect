package com.app.home;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.app.BaseApplication;
import com.app.component.BuildConfig;

public class HomeApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
    }

    @Override
    public void initModuleApp(Application application) {

    }

}
