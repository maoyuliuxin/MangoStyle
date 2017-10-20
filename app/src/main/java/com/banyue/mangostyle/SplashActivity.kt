package com.banyue.mangostyle

import android.os.Bundle
import com.banyue.commonlib.ui.base.BaseActivity
import com.banyue.uiroutelib.MAIN_ACTIVITY
import com.banyue.uiroutelib.startBase

class SplashActivity : BaseActivity() {

    override fun getLayoutRes(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initData() {
        //验证是否处于登录中
        if (true) {
            //进入主页
            startBase(MAIN_ACTIVITY)
            finish()
        } else {
            //登录
        }
    }

    override fun initView() {
    }
}
