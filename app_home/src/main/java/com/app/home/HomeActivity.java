package com.app.home;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.app.base.BaseActivity;
import com.app.common.config.PathConfig;
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
        //测试数据库
//        ThreadUtils.executeByCached(new ThreadUtils.SimpleTask<String>() {
//            @Override
//            public String doInBackground() throws Throwable {
//                Task task = new Task();
//                task.setTaskId("9876");
//                DBUtils.getInstance().getDB().taskDao().insert(task);
//                return task.getTaskId();
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                LogUtils.e(result);
//            }
//        });


    }
}
