package com.banyue.commonlib.basemvp

import android.content.Context
import android.os.Bundle
import com.banyue.commonlib.ui.base.BaseActivity
import java.lang.reflect.ParameterizedType


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

abstract class MVPBaseActivity<V : BaseView, T : BasePresenterImpl<V>> : BaseActivity(), BaseView {
    var mPresenter: T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = getInstance<T>(this, 1)
        mPresenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null)
            mPresenter!!.detachView()
    }

    override fun getViewContext(): Context = this

    fun <T> getInstance(o: Any, i: Int): T? {
        try {
            return ((o.javaClass
                    .genericSuperclass as ParameterizedType).actualTypeArguments[i] as Class<T>)
                    .newInstance()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

        return null
    }
}
