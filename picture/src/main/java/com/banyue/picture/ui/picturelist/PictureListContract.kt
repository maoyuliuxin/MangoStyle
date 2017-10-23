package com.banyue.picture.ui.picturelist

import com.banyue.commonlib.basemvp.BasePresenter
import com.banyue.commonlib.basemvp.BaseView
import com.banyue.picture.module.bean.PicBean

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class PictureListContract {
    interface View : BaseView {
        fun onSuccessPull(data: PicBean)
        fun onSuccessDown(data: PicBean)
        fun onDefeatPull()
        fun onDefeatDown()
    }

    interface Presenter : BasePresenter<View> {
        fun getPicList(size: Int, state: Int)
    }
}
