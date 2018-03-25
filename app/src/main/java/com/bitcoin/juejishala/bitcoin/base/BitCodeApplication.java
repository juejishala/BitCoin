package com.bitcoin.juejishala.bitcoin.base;

import android.app.Application;

import com.bitcoin.juejishala.bitcoin.ImageUtils.ImageLoader;

/**
 * Created by yinyayue on 2018/3/13.
 */

public class BitCodeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
    }

    private void initImageLoader() {
        ImageLoader.init(getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.clearAllMemoryCaches();

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoader.TrimMemory(level);
    }
}
