package com.banyue.uiroutelib

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by Administrator on 2017/10/11.
 */
fun startMain() {
    ARouter.getInstance().build("/banyue/textmain").navigation()
}