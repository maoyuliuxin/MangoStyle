package com.banyue.picture.ui.picturelist

import android.widget.ImageView
import com.banyue.commonlib.utils.setUrlBig
import com.banyue.picture.R
import com.banyue.picture.module.bean.PicBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by Administrator on 2017/10/23.
 */
class PictureListAdapter(res: Int = R.layout.item_pic, datas: ArrayList<PicBean.Newslist>)
    : BaseQuickAdapter<PicBean.Newslist, BaseViewHolder>(res, datas) {
    override fun convert(helper: BaseViewHolder?, item: PicBean.Newslist?) {
        helper?.setText(R.id.tv_details, item?.title)
        helper?.getView<ImageView>(R.id.iv_pic)?.setUrlBig(item?.picUrl ?: "")
    }
}