package com.csizg.rxjava.rxjava;

import com.csizg.rxjava.Utils.LogUtil;
import com.csizg.rxjava.entity.People;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Leo on 2018/4/11.
 *
 * @description：
 */

public class RxJavaManager {
    private static RxJavaManager manager;
    private static final String TAG = "LogUtil";

    public static RxJavaManager getManager() {
        if (null == manager) {
            manager = new RxJavaManager();
        }
        return manager;
    }

    public void testRxJava() {
        People[] strings = new People[3];
        strings[0] = new People(0,10, "张10");
        strings[1] = new People(1,11, "张11");
        strings[2] = new People(2,12, "张12");

        Observable.from(strings)
                .map(new Func1<People, String>() {
                    @Override
                    public String call(People people) {
                        return runTest(people);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "testRxJava", "onCompleted " );
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LogUtil.i(TAG, "testRxJava", "onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.i(TAG, "testRxJava", "s: " + s);
                    }
                });
    }

    private String runTest(People people){
        String msg = "";
        switch (people.getId()) {
            case 0:
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg = "Runnable0" + "  " + people.getAge() + "  " + people.getName();
                LogUtil.i(TAG, "runTest","Runnable0" + "  " + people.getAge() + "  " + people.getName());
                break;
            case 1:
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg = "Runnable1" + "  " + people.getAge() + "  " + people.getName();
                LogUtil.i(TAG, "runTest","Runnable1" + "  " + people.getAge() + "  " + people.getName());
                break;
            case 2:
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg = "Runnable2" + "  " + people.getAge() + "  " + people.getName();
                LogUtil.i(TAG, "runTest","Runnable2" + "  " + people.getAge() + "  " + people.getName());
                break;
        }
        return msg;
    }

}
