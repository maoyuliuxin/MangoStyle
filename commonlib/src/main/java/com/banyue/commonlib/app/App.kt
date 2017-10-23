package com.banyue.commolib.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.banyue.commonlib.R
import com.banyue.dblib.InstallDb
import com.banyue.uiroutelib.InstallRoute
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader


/**
 * Created by Administrator on 2017/8/3.
 */
class App : Application() {

    companion object {
        lateinit var sContext: Context
        lateinit var sApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("app", "运行了吗")
        sContext = this
        sApplication = this
        InstallRoute.installApp(this)
        InstallDb.installApp(this)
//        initRefresh()
    }

    private fun initRefresh() {
//        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(DefaultRefreshHeaderCreater { context, layout ->
            layout.setPrimaryColorsId(R.color.color_white, R.color.color_555)//全局设置主题颜色
            ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate)//指定为经典Header，默认是 贝塞尔雷达Header
        })
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(DefaultRefreshFooterCreater { context, layout ->
            //指定为经典Footer，默认是 BallPulseFooter
            ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate)
        })
    }

}