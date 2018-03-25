package com.bitcoin.juejishala.bitcoin.ImageUtils;

import android.content.Context;
import android.view.View;

import com.bitcoin.juejishala.bitcoin.service.DownLoadImageService;
import com.bumptech.glide.MemoryCategory;

/**
 * Created by yinyayue on 2018/3/25.
 */

class GlideLoader implements ILoader {
    @Override
    public void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD) {

    }

    @Override
    public void request(SingleConfig config) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void clearDiskCache() {

    }

    @Override
    public void clearMemoryCache(View view) {

    }

    @Override
    public void clearMemory() {

    }

    @Override
    public boolean isCached(String url) {
        return false;
    }

    @Override
    public void trimMemory(int level) {

    }

    @Override
    public void clearAllMemoryCaches() {

    }

    @Override
    public void saveImageIntoGallery(DownLoadImageService downLoadImageService) {

    }
}
