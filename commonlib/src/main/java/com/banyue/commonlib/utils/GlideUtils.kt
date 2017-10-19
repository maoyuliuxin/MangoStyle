package com.banyue.commonlib.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

/**
 * Created by Administrator on 2017/8/29.
 */
fun ImageView.setUrl(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}

fun ImageView.setRoundUrl(url: String) {
    Glide.with(context)
            .load(url)
            .transform(CenterCrop(context), GlideRoundTransform(context, 8))
            .into(this)
}