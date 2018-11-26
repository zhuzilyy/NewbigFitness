package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.gufei.bigfitness.R;

import static com.example.gufei.bigfitness.Constants.BASEURL;
import static com.example.gufei.bigfitness.Constants.IMAGURL;


/**
 * Created by tre on 16/9/26.
 *
 * 图片加载项
 *
 */

public abstract class LoadImage {


    /**
     * 图片加载
     ** @param context 父容器;
     ** @param imageUrl 图片地址;
     ** @param errorImageId 错误图片;
     ** @param imageView 显示容器;

     */
    public static void loadIntoUseFitWidth(Context context, final String imageUrl, int errorImageId, final ImageView imageView) {

        Glide.with(context)
                .load(IMAGURL+imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .fitCenter()
                .listener(new RequestListener<String, GlideDrawable>() {

                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        if (imageView == null) {

                            return false;
                        }
                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
//                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
//                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
//                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
//                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                        imageView.setLayoutParams(params);
                        return false;
                    }
                })
                .placeholder(R.color.white)
                .error(errorImageId)
                .crossFade()
                .into(imageView);
    }

//    public static void loadIntoUsecenterCrop(Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
//
//        Glide.with(context)
//                .load(imageUrl)
//                .crossFade()
//                .dontAnimate()
////                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .listener(new RequestListener<String, GlideDrawable>() {
//
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//
//                        if (imageView == null) {
//                            return false;
//                        }
//                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
//                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                        }
//                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
//                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
//                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
//                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
//                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
//                        imageView.setLayoutParams(params);
//                        return false;
//                    }
//                })
//                .placeholder(errorImageId)
//                .error(errorImageId)
//                .into(imageView);
//    }


}
