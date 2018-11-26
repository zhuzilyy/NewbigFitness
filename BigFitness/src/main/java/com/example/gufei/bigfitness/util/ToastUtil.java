package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.widget.Toast;



/**
 * Toast 工具类
 * 本类保持封装单体 Toast ,直接改变当前 Toast 内容,不会重复显示.
 *
 * @author GuFei
 * @version 2016 10 04 10:29
 */
public class ToastUtil {

    private ToastUtil() {
    }

    private static Toast toast;

    /**
     * 短时间 Toast
     *  @param context context
     * @param message message
     */
    public static void s(Context context, CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /**
     * 长时间 Toast
     *
     * @param context context
     * @param message message
     */
    public static void l(Context context, CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        } else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.show();
    }
}