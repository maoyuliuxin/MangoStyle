package com.banyue.dblib

import android.app.Application
import io.realm.Realm

/**
 * Created by Administrator on 2017/10/11.
 */

object InstallDb {
    fun installApp(app: Application) {
        Realm.init(app)
    }
}
