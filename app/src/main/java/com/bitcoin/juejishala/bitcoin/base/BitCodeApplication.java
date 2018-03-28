package com.bitcoin.juejishala.bitcoin.base;

import android.app.Application;

import com.bitcoin.juejishala.bitcoin.utils.CrashHandler;


/**
 * @author yinyayue
 * @date 2018/3/13
 */

public class BitCodeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.getInstance().init(getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
