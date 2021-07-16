package com.app.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.app.utils.image.ImageLoadUtils

fun ImageView.loadImage(url: Any?) {
    url?.let {
        ImageLoadUtils.loadImage(it, this)
    }

}

fun ImageView.loadImageNoScaleType(url: Any?) {
    url?.let {
        ImageLoadUtils.loadImageNoScaleType(it, this)
    }

}

fun ImageView.loadImage(url: Any?, @DrawableRes default: Int) {
    if (url == null) {
        ImageLoadUtils.loadImage(default, this, default, default)
    } else {
        ImageLoadUtils.loadImage(url, this, default, default)
    }
}

fun ImageView.loadCircleImage(url: Any?, @DrawableRes default: Int) {
    if (url == null) {
        ImageLoadUtils.loadCircleImage(default, this, default, default)
    } else {
        ImageLoadUtils.loadCircleImage(url, this, default, default)
    }
}

fun ImageView.loadCircleImage(url: Any?) {
    url?.let {
        ImageLoadUtils.loadCircleImage(it, this)
    }

}

/**
 * 圆形图片
 */
fun ImageView.loadRadius(url: Any?, radius: Int) {
    url?.let {
        ImageLoadUtils.loadRadius(it, this, radius)
    }
}

/**
 * 圆形图片
 */
fun ImageView.loadRadius(url: Any?, radius: Int, @DrawableRes error: Int) {
    if (url == null) {
        ImageLoadUtils.loadRadius(error, this, radius, error)
    } else {
        ImageLoadUtils.loadRadius(url, this, radius, error)
    }
}

