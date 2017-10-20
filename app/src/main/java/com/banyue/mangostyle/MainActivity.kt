package com.banyue.mangostyle

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.banyue.commonlib.module.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Build.VERSION.SDK_INT
        "test0".toast()
        val textView = TextView(this)
        textView.setOnClickListener {

        }
        text.onClick {  }
    }
}
