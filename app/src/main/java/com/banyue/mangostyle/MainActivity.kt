package com.banyue.mangostyle

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.banyue.commonlib.module.utils.toast
import com.banyue.commonlib.ui.base.BaseActivity
import com.banyue.commonlib.utils.setUrl
import com.banyue.uiroutelib.MAIN_ACTIVITY
import com.banyue.uiroutelib.PICTURE_LIST_FRAGMENT
import com.banyue.uiroutelib.getBaseFragment
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.find

@Route(path = MAIN_ACTIVITY)
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initData() {
        nav_view.getHeaderView(0)
                .find<CircleImageView>(R.id.ivHead)
                .setUrl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3906161185,333176228&fm=27&gp=0.jpg")
    }

    override fun initView() {
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        immersionBar.fitsSystemWindows(false).init()
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, getBaseFragment(PICTURE_LIST_FRAGMENT))
                .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.title.toString().toast()
        when (item.itemId) {
            R.id.nav_picture -> {

            }
            R.id.nav_express -> {

            }
            R.id.nav_movie -> {

            }
            R.id.nav_music -> {

            }
            R.id.nav_travel -> {

            }
            R.id.nav_about -> {

            }
            R.id.nav_centre -> {

            }
            R.id.nav_logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
