package com.banyue.commonlib.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.banyue.commolib.app.AppManage
import com.banyue.commonlib.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.head_toolbar.*


/**
 * Created by Qiangshen on 2017/8/3.
 */
abstract class BaseActivity : AppCompatActivity() {

    lateinit var immersionBar: ImmersionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doBeforeSetContentView()
        setContentView(getLayoutRes())
        setStateBar()
        setToolbar()
        init()
    }

    private fun init() {
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()

    /**
     * 初始化statusbar
     */
    private fun setStateBar() {
        immersionBar = ImmersionBar.with(this)
                .navigationBarEnable(false)
                .statusBarColor(R.color.colorPrimaryDark)
                .statusBarAlpha(0.2F)
                .fitsSystemWindows(true)
        immersionBar.init()
    }

    /**
     * 初始化toolbar
     */
    private fun setToolbar() {
        if (toolbar != null) {
            toolbar.title = ""
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    /**
     * app管理
     */
    private fun doBeforeSetContentView() {
        AppManage.INSTANT.addActivity(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        immersionBar.destroy()
        AppManage.INSTANT.removeActivity(this)
        super.onDestroy()
    }

    abstract fun getLayoutRes(): Int
}