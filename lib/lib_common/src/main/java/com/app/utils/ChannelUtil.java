package com.app.utils;

import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.meituan.android.walle.WalleChannelReader;

/**
 * 渠道工具类
 */
public class ChannelUtil {

    /**
     * 返回市场。  如果获取失败返回""
     *
     * @return
     */
    public static String getChannel() {
        return getChannel(Utils.getApp(), "test");
    }

    /**
     * 返回市场。  如果获取失败返回defaultChannel
     *
     * @param context
     * @param defaultChannel
     * @return
     */
    public static String getChannel(Context context, String defaultChannel) {
        return WalleChannelReader.getChannel(context, defaultChannel);// 获取渠道名称;
    }

}
