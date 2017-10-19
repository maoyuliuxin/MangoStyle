package com.banyue.commonlib.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Administrator on 2017/8/21.
 */
fun String.getSign() :String{
    var md: MessageDigest? = null
    var strDes: String? = null
    val bt = this.toByteArray()
    try {
        md = MessageDigest.getInstance("SHA-1")// 将此换成SHA-1、SHA-512、SHA-384等参数
        md?.update(bt)
        strDes = md!!.digest().bytes2Hex() // to HexString
    } catch (e: NoSuchAlgorithmException) {
        return ""
    }
    return strDes
}

fun ByteArray.bytes2Hex(): String {
    var des = ""
    var tmp: String? = null
    for (i in this.indices) {
        tmp = Integer.toHexString(this[i].toInt() and 0XFF)
        if (tmp!!.length == 1) {
            des += "0"
        }
        des += tmp
    }
    return des
}



