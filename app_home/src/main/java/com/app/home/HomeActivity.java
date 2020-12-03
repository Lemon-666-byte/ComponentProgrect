package com.app.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.app.base.BaseActivity;
import com.app.config.PathConfig;

@Route(path = PathConfig.Main.HomeActivity)
public class HomeActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void addListeners() {

    }
}
