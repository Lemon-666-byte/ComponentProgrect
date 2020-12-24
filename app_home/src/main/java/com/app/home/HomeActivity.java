package com.app.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.base.BaseActivity;
import com.app.config.EventConfigs;
import com.app.config.PathConfig;
import com.app.home.fragment.HomeFragment;
import com.blankj.utilcode.util.FragmentUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;

@Route(path = PathConfig.Home.HomeActivity)
public class HomeActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    protected void setData() {
        FragmentUtils.add(getSupportFragmentManager(), new HomeFragment(), R.id.rlContent);
    }

    @Override
    protected void addListeners() {

    }
}
