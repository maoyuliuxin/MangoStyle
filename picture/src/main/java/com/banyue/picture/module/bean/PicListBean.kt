package com.banyue.picture.module.bean

/**
 * Created by Administrator on 2017/10/23.
 */
data class PicListBean(var tooltips: Tooltips,
                       var images: ArrayList<Images>) {
    data class Tooltips(var loading: String,
                        var previous: String,
                        var next: String,
                        var walle: String,
                        var walls: String)

    data class Images(var startdate: String,
                      var fullstartdate: String,
                      var enddate: String,
                      var url: String,
                      var urlbase: String,
                      var copyright: String,
                      var copyrightlink: String,
                      var quiz: String,
                      var wp: Boolean,
                      var hsh: String,
                      var drk: Int,
                      var top: Int,
                      var bot: Int)
}