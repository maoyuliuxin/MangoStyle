package com.banyue.uiroutelib

import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by Administrator on 2017/10/20.
 */
fun startBase(router: String) {
    ARouter.getInstance().build(router).navigation()
}

fun getBaseFragment(router: String): Fragment = ARouter.getInstance().build(router).navigation() as Fragment