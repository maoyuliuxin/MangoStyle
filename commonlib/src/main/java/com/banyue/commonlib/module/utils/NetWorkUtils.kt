package com.banyue.commonlib.module.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast
import com.banyue.commolib.app.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/8/1.
 */
fun Context.isNetworkAvailable(): Boolean {
    var cm: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    var current: NetworkInfo = cm.activeNetworkInfo ?: return false
    return current.isAvailable
}

fun String.toast() {
    Toast.makeText(App.sContext, this, Toast.LENGTH_SHORT).show()
}

fun String.toastOnMain() {
    Observable.just(this)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Toast.makeText(App.sContext, this, Toast.LENGTH_SHORT).show()
            }
}

fun Any.log(msg: String) {
    Log.e(this.javaClass.simpleName, msg)
}