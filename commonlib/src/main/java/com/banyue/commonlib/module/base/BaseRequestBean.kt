package com.banyue.commonlib.module.base

import com.banyue.commonlib.constant.CLIENT
import com.banyue.commonlib.constant.KEY_SIGN
import com.banyue.commonlib.utils.getSign


/**
 * Created by Administrator on 2017/8/24.
 */
data class BaseRequestBean<T>(val timeStamp: String = (System.currentTimeMillis() / 1000L).toString(),
                              val sign: String = (timeStamp + KEY_SIGN).getSign(),
                              val client: String = CLIENT,
                              var params: T?)