package com.app.utils.image;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;


import com.app.base.R;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageLoadUtils {
    /**
     * Gif播放完毕回调
     */
    public interface GifListener {
        void gifPlayComplete();
    }

    public static boolean contextIsDestroyed(ImageView imageView) {
        if (imageView == null) return true;
        Context context = imageView.getContext();
        if (context instanceof FragmentActivity) {
            return ((FragmentActivity) context).isDestroyed();
        } else if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        } else {
            return false;
        }
    }

    public static void loadImageNoScaleType(Object url, ImageView imageView) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    public static void loadImage(Object url, ImageView imageView) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        Glide.with(imageView.getContext()).load(url).centerCrop().transition(withCrossFade()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 圆形图片
     */
    public static void loadRadius(Object url, ImageView imageView, int radius) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .transition(withCrossFade())
                .transform(new GlideRoundTransform(imageView.getContext(), SizeUtils.dp2px(radius)))
                .into(imageView);
    }

    /**
     * 圆形图片
     */
    public static void loadRadius(Object url, ImageView imageView, int radius, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(error)
                .fallback(error)
                .error(error)
                .transition(withCrossFade())
                .transform(new GlideRoundTransform(imageView.getContext(), SizeUtils.dp2px(radius)))
                .into(imageView);
    }

    public static void loadImage(Object url, ImageView imageView, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.colorBBB)
                .centerCrop()
                .fallback(error)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadImage(Object url, ImageView imageView, @DrawableRes int placeholder, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                .fallback(error)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadCircleImage(Object url, ImageView imageView) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop();
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadCircleImage(Object url, ImageView imageView, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .fallback(error)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop();
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadCircleImage(Object url, ImageView imageView, @DrawableRes int placeholder, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)
                .fallback(error)
                .error(error)
                .circleCrop();
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadCornersImage(Object url, ImageView imageView, int corners, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(SizeUtils.dp2px(corners)))
                .placeholder(R.color.colorBBB)
                .fallback(error)
                .error(error);
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    public static void loadCornersImage(Object url, ImageView imageView, int corners) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(SizeUtils.dp2px(corners)));
        Glide.with(imageView.getContext()).load(url)
                .apply(options)
                .into(imageView);
    }

    public static void loadCornersImage(Object url, ImageView imageView, int corners, @DrawableRes int placeholder, @DrawableRes int error) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(SizeUtils.dp2px(corners)))
                .placeholder(placeholder)
                .fallback(error)
                .error(error);
        Glide.with(imageView.getContext()).load(url).transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }


    public static void loadCatGifImage(Object url, int loading, ImageView imageView) {
        if (imageView == null || url == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(loading)
                .fallback(loading)
                .error(loading);

        Glide.with(Utils.getApp())
                .asGif()
                .load(url)
                .apply(options).transition(withCrossFade())
                .into(imageView);
    }

    public static void loadOneTimeGif(Object url, final ImageView imageView, final GifListener gifListener) {
        if (imageView == null || contextIsDestroyed(imageView)) return;
        RequestOptions options = new RequestOptions()
                .centerCrop();

        Glide.with(imageView.getContext())
                .asGif()
                .apply(options)
                .load(url).transition(withCrossFade())
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        try {
                            Field gifStateField = GifDrawable.class.getDeclaredField("state");
                            gifStateField.setAccessible(true);
                            Class gifStateClass = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState");
                            Field gifFrameLoaderField = gifStateClass.getDeclaredField("frameLoader");
                            gifFrameLoaderField.setAccessible(true);
                            Class gifFrameLoaderClass = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader");
                            Field gifDecoderField = gifFrameLoaderClass.getDeclaredField("gifDecoder");
                            gifDecoderField.setAccessible(true);
                            Class gifDecoderClass = Class.forName("com.bumptech.glide.gifdecoder.GifDecoder");
                            Object gifDecoder = gifDecoderField.get(gifFrameLoaderField.get(gifStateField.get(resource)));
                            Method getDelayMethod = gifDecoderClass.getDeclaredMethod("getDelay", int.class);
                            getDelayMethod.setAccessible(true);
                            //设置只播放一次
                            resource.setLoopCount(1);
                            //获得总帧数
                            int count = resource.getFrameCount();
                            int delay = 0;
                            for (int i = 0; i < count; i++) {
                                //计算每一帧所需要的时间进行累加
                                delay += (int) getDelayMethod.invoke(gifDecoder, i);
                            }
                            imageView.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (gifListener != null) {
                                        gifListener.gifPlayComplete();
                                    }
                                }
                            }, delay);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                }).into(imageView);
    }
}
