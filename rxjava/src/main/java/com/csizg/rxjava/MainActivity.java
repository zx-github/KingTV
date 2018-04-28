package com.csizg.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.csizg.rxjava.greendao.DaoManager;
import com.csizg.rxjava.retrofit.RetrofitManager;
import com.csizg.rxjava.rxjava.RxJavaManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.clickMi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMI();
            }
        });
    }

    private void onClickMI(){
//        RxJavaManager.getManager().testRxJava();
//        RetrofitManager.getManager().requestGet();
//        RetrofitManager.getManager().requestPost();
//        DaoManager.getManager().testGreenDao();
        DaoManager.getManager().startActivity();

    }

}
