package com.csizg.rxjava;

import android.app.Application;
import android.content.Context;

/**
 * Created by Leo on 2018/4/13.
 *
 * @description：
 */

public class MyApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getmContext() {
        return mContext.getApplicationContext();
    }
}
