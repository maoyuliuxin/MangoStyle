package com.banyue.newsongqian.utils

import android.widget.TextView
import com.banyue.commonlib.module.utils.log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/8/24.
 */
fun TextView.countDown(count: Long): Disposable {
    this.isEnabled = false
    return Observable.interval(1, TimeUnit.SECONDS)
            .take(count)
            .map { 60 - it - 1 }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                    onComplete = {
                        this.isEnabled = true
                        this.text = "再次发送"
                    },
                    onNext = {
                        this.log("it=$it")
                        this.text = "已发送" + it
                    }
            )
}