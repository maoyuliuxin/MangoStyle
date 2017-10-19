package com.banyue.commonlib.module.interf

import io.reactivex.disposables.Disposable

/**
 * Created by Qiangshen on 2017/8/3.
 */
interface ISubscriber<in T> {

    fun doOnNext(data: T?, code: String, msg: String)

    fun doOnError(msg: String)

    fun doOnNoData()

    fun doOnCompleted()

    fun doOnSub(d: Disposable)
}

