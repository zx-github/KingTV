package com.csizg.rxjava;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.csizg.rxjava.mvp.MvpPresenter;
import com.csizg.rxjava.mvp.MvpView;

public class Main2Activity extends AppCompatActivity implements MvpView {

    //进度条
    ProgressDialog progressDialog;
    TextView text;
    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = (TextView)findViewById(R.id.text);
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MvpPresenter(this);
    }

    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }
    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }
    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    @Override
    public void showData(String data) {
        text.setText(data);
    }
    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }
    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");
    }

}


/**
 * http://www.jcodecraeer.com/a/anzhuokaifa/2017/1020/8625.html?1508484926

 MVP 模式将Activity 中的业务逻辑全部分离出来，让Activity 只做 UI 逻辑的处理，
 所有跟Android API无关的业务逻辑由 Presenter 层来完成。

 将业务处理分离出来后最明显的好处就是管理方便，但是缺点就是增加了代码量。

 MVP 理论知识
 在MVP 架构中跟MVC类似的是同样也分为三层。

 Activity 和Fragment 视为View层，负责处理 UI。

 Presenter 为业务处理层，既能调用UI逻辑，又能请求数据，该层为纯Java类，不涉及任何Android API。

 Model 层中包含着具体的数据请求，数据源。

 三层之间调用顺序为view->presenter->model，为了调用安全着想不可反向调用！不可跨级调用！


 */
