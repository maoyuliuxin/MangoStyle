package com.banyue.commonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/5.
 */

public class AppScreenMgr {
    /**
     * Get the width of the screen.
     * 获得屏幕宽度
     *
     * @param context The context to use. Usually your
     *                {@link android.app.Application} or
     *                {@link Activity} object.
     * @return Return the width of the screen.
     */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    /**
     * Get the height of the screen.
     * 获得屏幕高度
     *
     * @param context The context to use. Usually your
     *                {@link android.app.Application} or
     *                {@link Activity} object.
     * @return Return the height of the screen.
     */
    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }


    /**
     * 功能描述：获取整块屏幕的高度
     *
     * @param context
     * @return int
     */
    public static int getRealScreenHeight(Context context) {
        int dpi = 0;
        Display display = ((Activity) context).getWindowManager()
                .getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked") Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    /**
     * 功能描述：获取虚拟按键区域的高度
     *
     * @param context
     * @return int 如果有虚拟按键则返回其高度否则返回0；
     */
    public static int getNavigationAreaHeight(Context context) {
        int realScreenHeight = AppScreenMgr.getRealScreenHeight(context);
        int screenHeight = AppScreenMgr.getScreenHeight(context);

        return realScreenHeight - screenHeight;
    }

    private AppScreenMgr() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

}
