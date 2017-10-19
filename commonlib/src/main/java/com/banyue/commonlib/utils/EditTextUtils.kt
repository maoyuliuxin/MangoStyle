package com.banyue.commonlib.utils

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText

/**
 * Created by Administrator on 2017/8/14.
 */
fun EditText.setPasswordVisibility(isVisible: Boolean) {
    if (!isVisible) { //密文
        this.transformationMethod = PasswordTransformationMethod.getInstance()
    } else { //明文密码
        this.transformationMethod = HideReturnsTransformationMethod.getInstance()
    }
    this.setSelection(text.length)
}

fun EditText.getString(): String = this.text.toString().trim()