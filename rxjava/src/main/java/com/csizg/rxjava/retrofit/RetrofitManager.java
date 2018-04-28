package com.csizg.rxjava.retrofit;


import com.csizg.rxjava.Utils.LogUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Leo on 2018/4/11.
 *
 * @description：
 */

public class RetrofitManager {
    private static RetrofitManager manager;

    public static RetrofitManager getManager() {
        if (null == manager) {
            manager = new RetrofitManager();
        }
        return manager;
    }

    public void requestGet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface gInterface = retrofit.create(GetRequest_Interface.class);
        Call<Translation> call = gInterface.getCall();
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                LogUtil.e("", "requestGet", "onFailure: " + t.getMessage());
            }
        });
    }
    public void requestPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        Call<Translation1> call = request_interface.getCall("I love you");
        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                String tgt = response.body().getTranslateResult().get(0).get(0).getTgt();
                LogUtil.i("", "requestPost", "tgt: " + tgt);
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {
                LogUtil.e("", "requestPost", "onFailure: " + t.getMessage());
            }
        });

    }
}
