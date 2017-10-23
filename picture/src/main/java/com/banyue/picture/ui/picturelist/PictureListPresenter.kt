package com.banyue.picture.ui.picturelist

import com.banyue.commonlib.basemvp.BasePresenterImpl
import com.banyue.commonlib.constant.PULL_REFRESH
import com.banyue.commonlib.module.base.BaseObserver
import com.banyue.commonlib.module.http.NetWorkFactory
import com.banyue.commonlib.module.http.observer
import com.banyue.commonlib.module.utils.log
import com.banyue.commonlib.module.utils.toast
import com.banyue.picture.module.PicApi
import com.banyue.picture.module.bean.PicBean


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class PictureListPresenter : BasePresenterImpl<PictureListContract.View>(), PictureListContract.Presenter {

    override fun getPicList(size: Int, state: Int) {
        "".log("size=$size")
        val picApi = NetWorkFactory.get().create(PicApi::class.java)
        picApi.getPicList(page = size.toString())
                .observer(object : BaseObserver<PicBean>() {
                    override fun doOnNext(data: PicBean?) {
                        if (data?.newslist?.size != 0) {
                            if (state == PULL_REFRESH) {
                                mView?.onSuccessPull(data)
                            } else {
                                mView?.onSuccessDown(data)
                            }
                        } else {
                            "没有数据".toast()
                        }
                    }

                    override fun doOnNoData() {
                        if (state == PULL_REFRESH) {
                            mView?.onDefeatPull()
                        } else {
                            mView?.onDefeatDown()
                        }
                    }

                })
    }
}
