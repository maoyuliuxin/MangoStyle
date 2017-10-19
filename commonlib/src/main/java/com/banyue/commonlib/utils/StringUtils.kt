package com.banyue.commonlib.utils

import java.text.SimpleDateFormat

/**
 * Created by Administrator on 2017/9/19.
 */
inline fun Int.Add0(): String = String.format("%03d", this)

inline fun Int.Add20(): String = String.format("%02d", this)

inline fun Int.dateForma(): String {
    val format = SimpleDateFormat("HH:mm:ss")
    return format.format(this)
}

inline fun Int.toTime(): String = (this / 60 / 60).Add20() + ":" + (this / 60 % 60).Add20() + ":" + (this % 60).Add20()