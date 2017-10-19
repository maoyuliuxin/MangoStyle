package com.banyue.commonlib.basemvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.banyue.commonlib.base.BaseFragment
import java.lang.reflect.ParameterizedType

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

abstract class MVPBaseFragment<V : BaseView, T : BasePresenterImpl<V>> : BaseFragment(), BaseView {
    var mPresenter: T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = getInstance<T>(this, 1)
        mPresenter!!.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    override fun getViewContext(): Context = context

    fun <T> getInstance(o: Any, i: Int): T? {
        try {
            return ((o.javaClass
                    .genericSuperclass as ParameterizedType).actualTypeArguments[i] as Class<T>)
                    .newInstance()
        } catch (e: Fragment.InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: ClassCastException) {
            e.printStackTrace()
        } catch (e: java.lang.InstantiationException) {
            e.printStackTrace()
        }

        return null
    }
}
