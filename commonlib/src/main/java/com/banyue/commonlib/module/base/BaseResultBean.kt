package com.banyue.commonlib.module.base

/**
 * Created by Qiangshen on 2017/8/3.
 */
data class BaseResultBean<out T>(val showapi_res_body: T ? = null, val showapi_res_code: Int, val showapi_res_error: String)
