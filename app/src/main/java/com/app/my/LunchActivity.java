package com.app.my;

import com.app.base.BaseActivity;
import com.app.test.R;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ViewUtils;

/**
 * 软件启动页面
 *
 * @author
 */
public class LunchActivity extends BaseActivity {


    @Override
    protected void initBar(boolean initBar) {
        super.initBar(false);
        BarUtils.transparentStatusBar(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.lunch_activity;
    }

    @Override
    protected void setData() {
        ViewUtils.runOnUiThreadDelayed(new Runnable() {
            @Override
            public void run() {
                
            }
        }, 2000);
    }

    @Override
    protected void addListeners() {

    }


}
