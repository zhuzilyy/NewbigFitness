package com.example.gufei.bigfitness.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

/**
 * Created by GuFei_lyf on 2017/6/1
 * <p>
 * 视频预览图生成类
 */

public class MediaMetadata {

    /**
     * 获取视频预览(为视频第一帧)
     * @param filePath 视频路径;
     * @return Bitmap  图片
     */

    public static Bitmap getVideoThumbnail(String filePath) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }


}
