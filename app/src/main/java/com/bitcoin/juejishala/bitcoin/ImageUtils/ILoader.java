package com.bitcoin.juejishala.bitcoin.ImageUtils;

import android.content.Context;
import android.view.View;

import com.bitcoin.juejishala.bitcoin.service.DownLoadImageService;
import com.bumptech.glide.MemoryCategory;

/**
 * Created by yinyayue on 2018/3/25.
 */

interface ILoader {
    void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD);

    void request(SingleConfig config);

    void pause();

    void resume();

    void clearDiskCache();

    void clearMemoryCache(View view);

    void clearMemory();

    boolean  isCached(String url);

    void trimMemory(int level);

    void clearAllMemoryCaches();

    void saveImageIntoGallery(DownLoadImageService downLoadImageService);
}
