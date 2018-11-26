package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.component.GlideCircleTransform;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.example.gufei.bigfitness.Constants.BASEURL;
import static com.example.gufei.bigfitness.Constants.IMAGURL;


/**
 * Created by wyc on 2017/2/7.
 */

public class GlideImageLoader  {

    public static void displayImage(Context context, Object path, ImageView imageView) {
        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */

//        Glide.with(context)
//                .load(url)
//                .asBitmap()
//                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                .get();

        //Glide 加载图片简单用法


        Glide
                .with(context)
                .load(BASEURL+path)
                .error(R.mipmap.privatememberinfor_03)
                .into(imageView);

    }

    public static void displayCircleImage(Context context, Object path, ImageView imageView,int err) {
//        Glide.get(context).clearMemory();
//        Glide.get(context).clearDiskCache();
        Glide.with(context)
//                .load(Uri.fromFile(new File(BASEURL+path)))
                .load(IMAGURL+path)
                .bitmapTransform(new GlideCircleTransform(context))
                .placeholder(err)
                .error(err)
                .into(imageView);

    }
}