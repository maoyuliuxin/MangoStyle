package com.banyue.picture.picturelist


import com.alibaba.android.arouter.facade.annotation.Route
import com.banyue.commonlib.basemvp.MVPBaseFragment
import com.banyue.picture.R
import com.banyue.uiroutelib.PICTURE_LIST_FRAGMENT


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

@Route(path = PICTURE_LIST_FRAGMENT)
class PictureListFragment : MVPBaseFragment<PictureListContract.View, PictureListPresenter>(), PictureListContract.View {

    override fun getLayoutRes(): Int = R.layout.fragment_picture_list

}
