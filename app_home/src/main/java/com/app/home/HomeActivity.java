package com.app.home;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.app.base.BaseActivity;
import com.app.config.PathConfig;
import com.app.home.databinding.HomeActivityBinding;
import com.app.home.fragment.HomeFragment;
import com.blankj.utilcode.util.FragmentUtils;

import org.jetbrains.annotations.NotNull;

@Route(path = PathConfig.Home.HomeActivity)
public class HomeActivity extends BaseActivity {
    HomeActivityBinding binding;

    @NotNull
    @Override
    protected View getLayoutId() {
        binding = HomeActivityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void setData() {
        FragmentUtils.add(getSupportFragmentManager(), new HomeFragment(), R.id.rlContent);
    }

    @Override
    protected void addListeners() {

    }
}
