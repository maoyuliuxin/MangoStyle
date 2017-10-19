package com.banyue.commonlib.module.http

import com.banyue.commonlib.module.base.BaseObserver
import com.banyue.commonlib.module.base.BaseResultBean
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by Qiangsehn on 2017/10/11.
 */

/**
 * 直接让Observable去调用
 */
inline fun <T> Observable<BaseResultBean<T>>.observer(observer: BaseObserver<T>) {
    this.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
}

inline fun String.toRequstBody(): RequestBody = RequestBody.create(MediaType.parse("text/plain"), this)