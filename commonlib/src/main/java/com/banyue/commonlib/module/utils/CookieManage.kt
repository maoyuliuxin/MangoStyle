package com.banyue.commonlib.module.utils

import com.banyue.commolib.app.App
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl


/**
 * Created by Qiangshen on 2017/8/2.
 */
class CookieManage : CookieJar {

    private val cookieStore = PersistentCookieStore(App.sContext)

    override fun saveFromResponse(url: HttpUrl?, cookies: List<Cookie>?) {
        if (cookies != null && cookies.size > 0) {
            for (item in cookies) {
                cookieStore.add(url!!, item)
            }
        }
    }

    override fun loadForRequest(url: HttpUrl?): List<Cookie> {
        val cookies = cookieStore[url!!]
        return cookies
    }
}