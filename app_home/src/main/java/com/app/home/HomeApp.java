package com.app.home;

import android.app.Application;

import com.app.BaseApplication;

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
