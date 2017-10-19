package com.banyue.commonlib.module.base

import com.banyue.commonlib.module.interf.ISubscriber
import com.banyue.commonlib.module.utils.log
import com.banyue.commonlib.module.utils.toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Qiangshen on 2017/8/3.
 */
abstract class BaseObserver<T> :
        Observer<BaseResultBean<T>>,
        ISubscriber<T> {

    override fun onComplete() {
        doOnCompleted()
    }

    override fun onError(e: Throwable) {
        doOnError(e.message ?: "")
    }

    override fun onSubscribe(d: Disposable) {
        doOnSub(d)
    }

    override fun onNext(t: BaseResultBean<T>) {
        "BaseHttp".log("resultData=$t")
        when (t.result) {
            "200" -> {
                //有数据
                doOnNext(t.datas, t.result, t.msg)
            }
            "-100" -> {
//                val intent = Intent(App.sContext, LoginActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                App.sContext.startActivity(intent)
//                AppManage.INSTANT.finishAllActivity()
                //请登录
                "请登录".toast()
            }
            "100" -> {
                t.msg.toast()
                doOnNoData()
            }
            else -> {
                //其他情况都在这里处理
                doOnNoData()
                t.msg.toast()
            }
        }
    }

    override fun doOnCompleted() {
        //取消请求数据Dialog，如果不想取消就复写该方法
    }

    override fun doOnSub(d: Disposable) {

    }

    override fun doOnError(msg: String) {
        "BaseHttp".log("error=$msg")
        "网络连接错误".toast()
        doOnNoData()
    }
}