package com.banyue.commolib.app

import android.app.Activity
import java.util.*

/**
 * Created by Qianshen on 2017/8/3.
 */
class AppManage private constructor() {

    private object Holder {
        val app: AppManage = AppManage()
    }

    companion object {
        val INSTANT: AppManage by lazy {
            Holder.app
        }
    }

    private val activityStack: Stack<Activity> = Stack()


    fun addActivity(activity: Activity?) {
        activityStack.add(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 结束最后一个activity
     */
    fun finishActivity() {
        val activity = activityStack.lastElement()
        activity.finish()
    }

    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
        }
    }

    /**
     * 获取当前的activity
     */
    fun currentActivity(): Activity? {
        try {
            val activity = activityStack.lastElement()
            return activity
        } catch (e: Exception) {
            return null
        }
    }

    /**
     * 结束所有的activity
     */
    fun finishAllActivity() {
        if (activityStack.size > 0) {
            for (activity in activityStack) {
                activity?.finish()
            }
        }
        activityStack.clear()
    }
}