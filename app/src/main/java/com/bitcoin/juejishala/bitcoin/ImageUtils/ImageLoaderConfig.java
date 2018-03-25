package com.bitcoin.juejishala.bitcoin.ImageUtils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import com.bumptech.glide.MemoryCategory;

/**
 * Created by yinyayue on 2018/3/25.
 */

public class ImageLoaderConfig {
    public static String baseUrl;
    public static Context context;
    /**
     * 屏幕高
     */
    public static int screenHeight;
    /**
     * 屏幕高
     */
    public static int screenWidth;
    /**
     * lrucache 最大值
     */
    public static int cacheMaxSize;
    /**
     * https是否忽略校验,默认不忽略
     */
    public static boolean ignoreCertificateVerify = false;

    public static void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD) {

        ImageLoaderConfig.context = context;
        ImageLoaderConfig.cacheMaxSize = cacheSizeInM;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        ImageLoaderConfig.screenWidth = wm.getDefaultDisplay().getWidth();
        ImageLoaderConfig.screenHeight = wm.getDefaultDisplay().getHeight();
        getLoader().init(context, cacheSizeInM, memoryCategory, isInternalCD);
    }

    private static Handler mainHandler;

    public static Handler getMainHandler() {
        if (mainHandler == null) {
            mainHandler = new Handler(Looper.getMainLooper());
        }
        return mainHandler;
    }

    private static ILoader loader;

    public static ILoader getLoader() {

        if (loader == null) {
            loader = new GlideLoader();
        }

        return loader;
    }

    public static int getWinHeight() {
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return screenHeight < screenWidth ? screenHeight : screenWidth;
        } else if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return screenHeight > screenWidth ? screenHeight : screenWidth;
        }
        return screenHeight;
    }

    public static int getWinWidth() {
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return screenHeight > screenWidth ? screenHeight : screenWidth;
        } else if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return screenHeight < screenWidth ? screenHeight : screenWidth;
        }
        return screenWidth;
    }
}
