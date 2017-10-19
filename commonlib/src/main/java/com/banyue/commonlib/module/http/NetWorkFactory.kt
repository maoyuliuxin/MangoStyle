package com.banyue.commonlib.module.http

import com.banyue.commolib.app.App
import com.banyue.commonlib.constant.BASE_URL
import com.banyue.commonlib.module.utils.CacheInterceptor
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by Qiangshen on 2017/8/1.
 */
class NetWorkFactory {

    private object Holder {
        val INSTANCE = NetWorkFactory()
    }

    companion object {
        fun get(): NetWorkFactory = Holder.INSTANCE
    }

    private val mRetrofit: Retrofit

    private constructor() {
        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(App.sContext))
        //设置了网络缓存
        val cacheFile: File = File(App.sApplication.cacheDir, "httpCache")
        val cache: Cache = Cache(cacheFile, 1024 * 1024 * 10)
        val client: OkHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(CacheInterceptor())
                .addInterceptor(CacheInterceptor())
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .cookieJar(cookieJar)
                .connectTimeout(15, TimeUnit.SECONDS)//超时时间15S
                .cache(cache)
                .build()

        //初始化Retrofit
        mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)//设置okHttp
                .addConverterFactory(GsonConverterFactory.create())//解析数据
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun <T> create(clazz: Class<T>): T = mRetrofit.create(clazz)

}