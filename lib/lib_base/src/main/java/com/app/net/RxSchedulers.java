package com.app.net;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 通用的Rx线程转换类
 * 参考:http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0819/3327.html
 */
public class RxSchedulers {

    static final ObservableTransformer schedulersTransformer = upstream -> (upstream).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }

}
