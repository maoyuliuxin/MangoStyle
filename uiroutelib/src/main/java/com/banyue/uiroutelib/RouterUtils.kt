package com.banyue.uiroutelib

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by Administrator on 2017/10/20.
 */
fun startBase(router: String) {
    ARouter.getInstance().build(router).navigation()
}