package com.app.my;

import com.app.base.BaseActivity;
import com.app.test.R;
import com.blankj.utilcode.util.BarUtils;

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
        return R.layout.activity_lunch;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void addListeners() {

    }


}
