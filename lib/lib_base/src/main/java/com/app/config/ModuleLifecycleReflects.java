package com.app.config;

/**
 * Created by zlx on 2020/9/22 14:26
 * Email: 1170762202@qq.com
 * Description:
 */
public class ModuleLifecycleReflects {
    /**
     * 基础库
     * src/main/java/com/app/module/CommonModuleInit.java
     */
    private static final String BaseInit = "com.app.module.CommonModuleInit";

    public static String[] initModuleNames = {BaseInit};
}
