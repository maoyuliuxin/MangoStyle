package com.banyue.picture.ui.picturelist


import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.banyue.commonlib.basemvp.MVPBaseFragment
import com.banyue.commonlib.constant.DOWN_REFRESH
import com.banyue.commonlib.constant.PULL_REFRESH
import com.banyue.picture.R
import com.banyue.picture.module.bean.PicBean
import com.banyue.uiroutelib.PICTURE_LIST_FRAGMENT
import kotlinx.android.synthetic.main.fragment_picture_list.*


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

@Route(path = PICTURE_LIST_FRAGMENT)
class PictureListFragment : MVPBaseFragment<PictureListContract.View, PictureListPresenter>(), PictureListContract.View {

    override fun onSuccessPull(data: PicBean?) {
        mAdapter.replaceData(data?.newslist ?: arrayListOf())
        refresh.finishRefresh(true)
    }

    override fun onSuccessDown(data: PicBean?) {
        mAdapter.addData(data?.newslist ?: arrayListOf())
        refresh.finishLoadmore(true)
    }

    override fun onDefeatPull() {
        refresh.finishRefresh(false)
    }

    override fun onDefeatDown() {
        refresh.finishLoadmore(false)
    }

    private val mAdapter by lazy {
        PictureListAdapter(datas = arrayListOf())
    }

    override fun getLayoutRes(): Int = R.layout.fragment_picture_list

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        refresh.autoRefresh(200)
    }

    private fun init() {
        initView()
    }

    private fun initView() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = mAdapter
        refresh.setOnRefreshListener {
            mPresenter?.getPicList(0, PULL_REFRESH)
        }
        refresh.setOnLoadmoreListener {
            mPresenter?.getPicList(mAdapter.data.size + 1, DOWN_REFRESH)
        }
    }
}
