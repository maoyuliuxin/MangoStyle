package com.banyue.commonlib.module.utils

import com.banyue.commolib.app.App
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Qiangshen on 2017/8/1.
 */
class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!App.sContext.isNetworkAvailable()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE) //从缓存中获取
                    .build()
        } else{
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_NETWORK) //从网络获取
                    .build()
        }
        val originalResponse = chain.proceed(request)
        if (App.sContext.isNetworkAvailable()) {
            val maxAge = 60 * 60
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build()
        } else {
            val maxTime = 4 * 24 * 60 * 60
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxTime)
                    .removeHeader("Pragma")
                    .build()
        }
    }


}