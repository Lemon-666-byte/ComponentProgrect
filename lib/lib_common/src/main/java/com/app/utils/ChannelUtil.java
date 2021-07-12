package com.app.utils;

import com.blankj.utilcode.util.Utils;
import com.meituan.android.walle.WalleChannelReader;

/**
 * 渠道工具类
 */
public class ChannelUtil {

    /**
     * 返回市场。  如果获取失败返回 "test"
     *
     * @return
     */
    public static String getChannel() {
        return getChannel("test");
    }

    /**
     * 返回市场。  如果获取失败返回defaultChannel
     *
     * @param defaultChannel
     * @return
     */
    public static String getChannel(String defaultChannel) {
        return WalleChannelReader.getChannel(Utils.getApp(), defaultChannel);// 获取渠道名称;
    }

}
