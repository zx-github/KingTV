package com.csizg.rxjava.Utils;

import android.util.Log;

/**
 * 日志管理工具
 * Created by CS-1113 on 2017/8/16.
 */

public class LogUtil {

    private static boolean DEBUG = true;

    private static final String BASE_TAG = "rxjava";

    public static void v(String TAG, String method, String msg) {
        if (DEBUG) {
            Log.v(BASE_TAG, TAG + "." + method + "()-->" + msg);
        }
    }

    public static void d(String TAG, String method, String msg) {
        if (DEBUG) {
            Log.d(BASE_TAG, TAG + "." + method + "()-->" + msg);
        }
    }

    public static void i(String TAG, String method, String msg) {
        if (DEBUG) {
            Log.i(BASE_TAG, TAG + "." + method + "()-->" + msg);
        }
    }

    public static void w(String TAG, String method, String msg) {
        if (DEBUG) {
            Log.w(BASE_TAG, TAG + "." + method + "()-->" + msg);
        }
    }

    public static void e(String TAG, String method, String msg) {
        if (DEBUG) {
            Log.e(BASE_TAG, TAG + "." + method + "()-->" + msg);
        }
    }
}
