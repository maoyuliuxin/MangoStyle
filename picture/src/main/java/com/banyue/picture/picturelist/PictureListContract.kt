package com.banyue.picture.picturelist

import com.banyue.commonlib.basemvp.BasePresenter
import com.banyue.commonlib.basemvp.BaseView

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class PictureListContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}
