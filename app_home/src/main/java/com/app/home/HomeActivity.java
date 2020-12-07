package com.app.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.app.base.BaseActivity;
import com.app.config.EventConfigs;
import com.app.config.PathConfig;
import com.jeremyliao.liveeventbus.LiveEventBus;

@Route(path = PathConfig.Home.HomeActivity)
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
