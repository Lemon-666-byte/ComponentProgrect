package com.app.module;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import com.app.BaseApplication;
import com.app.base.BuildConfig;
import com.app.room.utils.DBUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;


/**
 * Created by zlx on 2020/9/22 14:28
 * Email: 1170762202@qq.com
 * Description:
 */
public class CommonModuleInit implements IModuleInit {

    public static final String DATABASE_NAME = "inspect.db";

    @Override
    public boolean onInitAhead(Application application) {
        Utils.init(application);
        initARouter(application);
        initMMkv(application);
        initX5(application);
        DBUtils.getInstance().init(application, DATABASE_NAME);
        LogUtils.e("HomeApp", "HomeApp onInitAhead()");
        return false;
    }

    @Override
    public boolean onInitAfter(BaseApplication application) {
        return false;
    }

    /**
     * 初始化 路由
     */
    private void initARouter(Application application) {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
    }

    private void initX5(Application application) {
        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback() {

            @Override
            public void onCoreInitFinished() {
//                com.blankj.utilcode.util.LogUtils.e("x5 onCoreInitFinished()");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                com.blankj.utilcode.util.LogUtils.e("x5初始化->" + b);
            }
        };
        QbSdk.initX5Environment(application.getApplicationContext(), callback);
    }

    private void initMMkv(Application application) {
//        String dir = getFilesDir().getAbsolutePath() + "/mmkv";
        MMKV.initialize(application);
//        MMKV.initialize(dir, libName -> {
////            com.blankj.utilcode.util.LogUtils.e("MMKV", "mmkv libName: " + libName);
//            ReLinker.loadLibrary(this, libName);
//        });
    }
}
