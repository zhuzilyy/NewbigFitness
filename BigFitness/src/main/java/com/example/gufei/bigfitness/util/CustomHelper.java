package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.View;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;


/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 * Author: crazycodeboy
 * Date: 2016/9/21 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.cboy.me
 * GitHub:https://github.com/crazycodeboy
 * Eamil:crazycodeboy@gmail.com
 */
public class CustomHelper {
    private View rootView;
    private Context context;
    public static CustomHelper of(View rootView, Context context){
        return new CustomHelper(rootView,context);
    }
    private CustomHelper(View rootView, Context context) {
        this.rootView = rootView;
        this.context=context;
        init();
    }
    private void init(){
    }

    public void onClick(View view, TakePhoto takePhoto) {
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+ System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);

        if(SPUtils.get(context,"type","").equals("1")){
            takePhoto.onPickFromCaptureWithCrop(imageUri,getCropOptions());
        }else{
            takePhoto.onPickFromGalleryWithCrop(imageUri,getCropOptions());
        }
    }
    private void configTakePhotoOption(TakePhoto takePhoto){
        TakePhotoOptions.Builder builder=new TakePhotoOptions.Builder();
            builder.setWithOwnGallery(false);
            builder.setCorrectImage(true);
        takePhoto.setTakePhotoOptions(builder.create());

    }
    private void configCompress(TakePhoto takePhoto){

        int maxSize= Integer.parseInt("102400");
        int width= Integer.parseInt("800");
        int height= Integer.parseInt("800");
        CompressConfig config;
            config=new CompressConfig.Builder()
                    .setMaxSize(maxSize)
                    .setMaxPixel(width>=height? width:height)
                    .enableReserveRaw(true)
                    .create();

        takePhoto.onEnableCompress(config,true);


    }
    private CropOptions getCropOptions(){
        int height= Integer.parseInt("800");
        int width= Integer.parseInt("800");

        CropOptions.Builder builder=new CropOptions.Builder();
        builder.setOutputX(width).setOutputY(height);
        builder.setWithOwnCrop(true);
        return builder.create();
    }
}
