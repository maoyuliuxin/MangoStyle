package com.banyue.commonlib.basemvp

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

open class BasePresenterImpl<V : BaseView> : BasePresenter<V> {
    protected var mView: V? = null
    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}
