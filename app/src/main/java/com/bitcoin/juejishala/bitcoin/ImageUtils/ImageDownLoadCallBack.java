package com.bitcoin.juejishala.bitcoin.ImageUtils;

import android.graphics.Bitmap;

/**
 * Created by yinyayue on 2018/3/25.
 */

public interface ImageDownLoadCallBack {

    void onDownLoadSuccess(Bitmap bitmap);

    void onDownLoadFailed();
}
