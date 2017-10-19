package com.banyue.commonlib.module.base

/**
 * Created by Qiangshen on 2017/8/3.
 */
data class BaseResultBean<out T>(val datas: T ? = null, val result: String, val msg: String)
