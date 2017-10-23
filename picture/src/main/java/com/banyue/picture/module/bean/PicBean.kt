package com.banyue.picture.module.bean

/**
 * Created by Administrator on 2017/10/23.
 */
data class PicBean(var showapi_res_code: Int,
                   var showapi_res_error: String,
                   var showapi_res_body: ShowapiResBody) {
    data class ShowapiResBody(var code: Int,
                              var msg: String,
                              var newslist: ArrayList<Newslist>) {
        data class Newslist(var title: String,
                            var picUrl: String,
                            var description: String,
                            var ctime: String,
                            var url: String)
    }
}