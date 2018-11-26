package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Created by EDZ on 2018/4/2.
 */

public class SharedPreferencesUtils {
    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_date";
    public static final String TOKEN = "token";
    public static final String USERID = "user_id";
    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param context
     * @param key
     * @param object
     */
    public static void setParam(Context context , String key, Object object){

        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if("String".equals(type)){
            editor.putString(key, (String)object);
        }
        else if("Integer".equals(type)){
            editor.putInt(key, (Integer)object);
        }
        else if("Boolean".equals(type)){
            editor.putBoolean(key, (Boolean)object);
        }
        else if("Float".equals(type)){
            editor.putFloat(key, (Float)object);
        }
        else if("Long".equals(type)){
            editor.putLong(key, (Long)object);
        }

        editor.commit();
    }


    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getParam(Context context , String key, Object defaultObject){
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if("String".equals(type)){
            return sp.getString(key, (String)defaultObject);
        }

        else if("Integer".equals(type)){
            return sp.getInt(key, (Integer)defaultObject);
        }

        else if("Boolean".equals(type)){
            return sp.getBoolean(key, (Boolean)defaultObject);
        }

        else if("Float".equals(type)){
            return sp.getFloat(key, (Float)defaultObject);
        }

        else if("Long".equals(type)){
            return sp.getLong(key, (Long)defaultObject);
        }

        return null;
    }

    /**
     * 清除所有数据
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }

    /**
     * 清除指定数据
     * @param context
     */
    public static void clearAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("定义的键名");
        editor.commit();
    }

    private static void paraCheck(SharedPreferences sp, String key) {
        if (sp == null) {
            throw new IllegalArgumentException();
        }
        if (TextUtils.isEmpty(key)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean putBitmap(Context context, String key, Bitmap bitmap) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        paraCheck(sp, key);
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            String imageBase64 = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            SharedPreferences.Editor e = sp.edit();
            e.putString(key, imageBase64);
            return e.commit();
        }
    }

    public static Bitmap getBitmap(Context context, String key,
                                   Bitmap defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        paraCheck(sp, key);
        String imageBase64 = sp.getString(key, "");
        if (TextUtils.isEmpty(imageBase64)) {
            return defaultValue;
        }

        byte[] base64Bytes = Base64.decode(imageBase64.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        Bitmap ret = BitmapFactory.decodeStream(bais);
        if (ret != null) {
            return ret;
        } else {
            return defaultValue;
        }
    }

    public static boolean putDrawable(Context context, String key, Drawable d) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        paraCheck(sp, key);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ((BitmapDrawable) d).getBitmap()
                .compress(Bitmap.CompressFormat.JPEG, 50, baos);
        String imageBase64 = new String(Base64.encode(baos.toByteArray(),
                Base64.DEFAULT));
        SharedPreferences.Editor e = sp.edit();
        e.putString(key, imageBase64);
        return e.commit();
    }

    public static Drawable getDrawable(Context context, String key,
                                       Drawable defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        paraCheck(sp, key);
        String imageBase64 = sp.getString(key, "");
        if (TextUtils.isEmpty(imageBase64)) {
            return defaultValue;
        }

        byte[] base64Bytes = Base64.decode(imageBase64.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        Drawable ret = Drawable.createFromStream(bais, "");
        if (ret != null) {
            return ret;
        } else {
            return defaultValue;
        }
    }

    public static boolean putObject(Context context, String key, Object obj) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        paraCheck(sp, key);
        if (obj == null) {
            SharedPreferences.Editor e = sp.edit();
            e.putString(key, "");
            return e.commit();
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(baos);
                oos.writeObject(obj);
            } catch (IOException e1) {
                e1.printStackTrace();
                return false;
            }
            String objectBase64 = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            SharedPreferences.Editor e = sp.edit();
            e.putString(key, objectBase64);
            return e.commit();
        }
    }

    public static Object getObject(Context context, String key,
                                   Object defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        paraCheck(sp, key);
        String objectBase64 = sp.getString(key, "");
        if (TextUtils.isEmpty(objectBase64)) {
            return defaultValue;
        }
        byte[] base64Bytes = Base64.decode(objectBase64.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (StreamCorruptedException e) {
            // e.printStackTrace();
            return null;
        } catch (IOException e) {
            // e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            return null;
        }
    }

    public static boolean isObjectEqual(Context context, String key,
                                        Object newValue) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        paraCheck(sp, key);
        if (newValue == null) {
            return false;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(baos);
                oos.writeObject(newValue);
            } catch (IOException e1) {
                e1.printStackTrace();
                return false;
            }
            String newValueBase64 = new String(Base64.encode(
                    baos.toByteArray(), Base64.DEFAULT));
            String oldValueBase64 = sp.getString(key, "");
            return newValueBase64.equals(oldValueBase64);
        }
    }
}
