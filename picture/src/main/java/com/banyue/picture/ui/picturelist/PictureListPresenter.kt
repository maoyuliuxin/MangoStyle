package com.banyue.picture.ui.picturelist

import com.banyue.commonlib.basemvp.BasePresenterImpl
import com.banyue.commonlib.constant.PULL_REFRESH
import com.banyue.commonlib.module.http.NetWorkFactory
import com.banyue.commonlib.module.http.observer
import com.banyue.commonlib.module.utils.log
import com.banyue.commonlib.module.utils.toast
import com.banyue.picture.module.PicApi
import com.banyue.picture.module.bean.PicBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class PictureListPresenter : BasePresenterImpl<PictureListContract.View>(), PictureListContract.Presenter {

    override fun getPicList(size: Int, state: Int) {
        "".log("size=$size")
        val picApi = NetWorkFactory.get().create(PicApi::class.java)
        picApi.getPicList(page = size.toString())
                .observer(object : Observer<PicBean> {
                    override fun onNext(t: PicBean) {
                        if (t.showapi_res_body.code == 200) {
                            if (state == PULL_REFRESH) {
                                mView?.onSuccessPull(t)
                            } else {
                                mView?.onSuccessDown(t)
                            }
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        "".log("e=${e.message}")
                        "网络错误".toast()
                        if (state == PULL_REFRESH) {
                            mView?.onDefeatPull()
                        } else {
                            mView?.onDefeatDown()
                        }
                    }

                })
    }
}
