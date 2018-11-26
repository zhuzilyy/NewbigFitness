package com.example.gufei.bigfitness.component;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 图片加载
 * 封装 Glide 添加缓存 缓存类型
 * ALL:缓存源资源和转换后的资源 NONE:不作任何磁盘缓存 SOURCE:缓存源资源 RESULT：缓存转换后的资源
 *
 * @author GuFei
 * @version 2016 10 04 15:59
 */
public class ImageLoader {

    /**
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     */
    public static void load(Activity activity, String url, ImageView iv) {
        if(!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }
}