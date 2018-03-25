package com.bitcoin.juejishala.bitcoin.ImageUtils;

import android.content.Context;
import android.view.View;

import com.bitcoin.juejishala.bitcoin.service.DownLoadImageService;
import com.bumptech.glide.MemoryCategory;

/**
 * Created by yinyayue on 2018/3/25.
 */

public class ImageLoader {
    public static Context context;
    /**
     * 默认最大缓存
     */
    public static int CACHE_IMAGE_SIZE = 250;

    public static void init(final Context context) {
        init(context, CACHE_IMAGE_SIZE);
    }

    public static void init(final Context context, int cacheSizeInM) {
        init(context, cacheSizeInM, MemoryCategory.NORMAL);
    }

    public static void init(final Context context, int cacheSizeInM, MemoryCategory memoryCategory) {
        init(context, cacheSizeInM, memoryCategory, true);
    }

    /**
     * @param context        上下文
     * @param cacheSizeInM   Glide默认磁盘缓存最大容量250MB
     * @param memoryCategory 调整内存缓存的大小 LOW(0.5f) ／ NORMAL(1f) ／ HIGH(1.5f);
     * @param isInternalCD   true 磁盘缓存到应用的内部目录 / false 磁盘缓存到外部存
     */
    public static void init(final Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD) {
        ImageLoader.context = context;
        ImageLoaderConfig.init(context, cacheSizeInM, memoryCategory, isInternalCD);
    }

    /**
     * 程序低内存时清理执行
     */
    public static void clearAllMemoryCaches() {
        getActualLoader().clearAllMemoryCaches();
    }

    /**
     * 程序在内存清理的时候执行
     *
     * @param level
     */
    public static void TrimMemory(int level) {
        getActualLoader().trimMemory(level);
    }

    /**
     * 获取当前的Loader
     *
     * @return
     */
    public static ILoader getActualLoader() {
        return ImageLoaderConfig.getLoader();
    }

    /**
     * 加载普通图片
     *
     * @param context
     * @return
     */
    public static SingleConfig.ConfigBuilder with(Context context) {
        return new SingleConfig.ConfigBuilder(context);
    }

    public static void pauseRequests() {
        getActualLoader().pause();

    }

    public static void resumeRequests() {
        getActualLoader().resume();
    }

    /**
     * Cancel any pending loads Glide may have for the view and free any resources that may have been loaded for the view.
     *
     * @param view
     */
    public static void clearMemoryCache(View view) {
        getActualLoader().clearMemoryCache(view);
    }


    /**
     * Clears disk cache.
     * <p>
     * <p>
     * This method should always be called on a background thread, since it is a blocking call.
     * </p>
     */
    public static void clearDiskCache() {
        getActualLoader().clearDiskCache();
    }

    /**
     * Clears as much memory as possible.
     */
    public static void clearMomory() {
        getActualLoader().clearMemory();
    }

    /**
     * 图片保存到相册
     *
     * @param downLoadImageService
     */
    public static void saveImageIntoGallery(DownLoadImageService downLoadImageService) {
        getActualLoader().saveImageIntoGallery(downLoadImageService);
    }
}


