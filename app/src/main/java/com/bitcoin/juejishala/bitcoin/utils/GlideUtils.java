package com.bitcoin.juejishala.bitcoin.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * @author yinyayue
 * @date 2018/3/26
 */

public class GlideUtils {
    /**
     * @param context
     * @param imageUrl 图片地址
     * @param ivImage  显示图片的imageView
     */
    public static void displayImage(Context context, String imageUrl, ImageView ivImage) {
        displayImage(context, imageUrl, ivImage, 0, 0, 0, 0, true);
    }

    /**
     * @param context
     * @param imageUrl    图片地址
     * @param ivImage     显示图片的imageView
     * @param placeholder 图片占位符
     */
    public static void displayImage(Context context, String imageUrl, ImageView ivImage, int placeholder) {
        displayImage(context, imageUrl, ivImage, placeholder, placeholder, 0, 0, true);
    }

    /**
     * @param context
     * @param imageUrl    图片地址
     * @param ivImage     显示图片的imageView
     * @param placeholder 图片占位符
     * @param error       加载失败占位符
     */
    public static void displayImage(Context context, String imageUrl, ImageView ivImage, int placeholder, final int error) {
        displayImage(context, imageUrl, ivImage, placeholder, error, 0, 0, true);
    }

    /**
     * @param context
     * @param imageUrl    图片地址
     * @param ivImage     显示图片的imageView
     * @param placeholder 图片占位符
     * @param error       加载失败占位符
     * @param width       加载图片的宽
     * @param height      加载图片的高
     */
    public static void displayImage(Context context, String imageUrl, ImageView ivImage, int placeholder, int error, int width, int height) {
        displayImage(context, imageUrl, ivImage, placeholder, error, width, height, true);
    }

    /**
     * @param context
     * @param imageUrl    图片地址
     * @param ivImage     显示图片的imageView
     * @param placeholder 图片占位符
     * @param error       加载失败占位符
     * @param width       加载图片的宽
     * @param height      加载图片的高
     * @param cache       是否缓存
     */
    public static void displayImage(Context context, String imageUrl, ImageView ivImage, int placeholder, int error, int width, int height, boolean cache) {
        RequestOptions requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL).placeholder(placeholder).fallback(error).error(error);
        if (width > 0 && height > 0) {
            requestOptions.override(width, height);
        }
        if (!cache) {
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
        }
        displayImage(context, imageUrl, ivImage, requestOptions);
    }

    public static void displayImageByOriginalSize(Context context, String imageUrl, ImageView ivImage) {
        displayImageByOriginalSize(context, imageUrl, ivImage, 0, 0, 0, 0, true);
    }

    public static void displayImageByOriginalSize(Context context, String imageUrl, ImageView ivImage, int placeholder) {
        displayImageByOriginalSize(context, imageUrl, ivImage, placeholder, placeholder, 0, 0, true);
    }

    public static void displayImageByOriginalSize(Context context, String imageUrl, ImageView ivImage, int placeholder, final int error) {
        displayImageByOriginalSize(context, imageUrl, ivImage, placeholder, error, 0, 0, true);
    }

    public static void displayImageByOriginalSize(Context context, String imageUrl, ImageView ivImage, int placeholder, int error, int width, int height) {
        displayImageByOriginalSize(context, imageUrl, ivImage, placeholder, error, width, height, true);
    }

    public static void displayImageByOriginalSize(Context context, String imageUrl, ImageView ivImage, int placeholder, int error, int width, int height, boolean cache) {
        RequestOptions requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL).placeholder(placeholder).fallback(error).error(error).override(Target.SIZE_ORIGINAL);
        if (width > 0 && height > 0) {
            requestOptions.override(width, height);
        }
        if (!cache) {
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
        }
        displayImage(context, imageUrl, ivImage, requestOptions);
    }

    public static void displayImage(Context context, String imageUrl, ImageView ivImage, RequestOptions requestOptions) {
        if (context == null || ivImage == null) {
            return;
        }
        if (context instanceof Activity) {
            Activity activity = ((Activity) context);
            if (activity.isFinishing()) {
                return;
            }
        }
        if (!(ivImage.getTag() instanceof Request)) {
            ivImage.setTag(null);
        }
        try {
            Glide.with(context).setDefaultRequestOptions(requestOptions).asBitmap().load(imageUrl).into(ivImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
