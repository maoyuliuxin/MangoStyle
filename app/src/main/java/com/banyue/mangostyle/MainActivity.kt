package com.banyue.mangostyle

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.banyue.commonlib.module.utils.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Build.VERSION.SDK_INT
        "test0".toast()
    }
}
