package com.banyue.picture.module

import com.banyue.picture.module.bean.PicBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Administrator on 2017/10/23.
 */
interface PicApi {

    @GET("197-1")
    fun getPicList(
            @Query("showapi_appid") showapi_appid: String = "48444", //从第几条开始
            @Query("showapi_sign") showapi_sign: String = "addf96ce7e3a40c2a5531a913aa6b34f", //返回数量
            @Query("num") num: String = "10",
            @Query("page") page: String
//            @Query("rand") rand :String = "1"
    ): Observable<PicBean>
}