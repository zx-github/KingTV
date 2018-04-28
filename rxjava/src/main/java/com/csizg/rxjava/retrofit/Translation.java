package com.csizg.rxjava.retrofit;

import com.csizg.rxjava.Utils.LogUtil;

/**
 * Created by Leo on 2018/4/11.
 *
 * @description：
 */

public class Translation {
    private int status;
    private content content;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        LogUtil.i("", "show", "data:" + ("status:" + status + ",from :" + content.from + ",to :" + content.to
         + ",vendor : " + content.vendor + ",out :" + content.out + ",errNo: " + content.errNo));
    }
}
