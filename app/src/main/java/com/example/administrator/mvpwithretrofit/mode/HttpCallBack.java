package com.example.administrator.mvpwithretrofit.mode;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.example.administrator.mvpwithretrofit.basePresent.present.BasePresenter;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;


public abstract class HttpCallBack<ResultType> {

    public void onStart() {
    }

    /**
     * 请求完成
     */
    public void onCompleted() {

    }
    /**
     * 请求出错
     *
     * @param error
     */
    public void onError(Throwable error) {

    }

    /**
     * 请求成功
     *
     * @param result 创建Subscriber时的泛型类型
     */
    public void onSuccess(ResultType result) {

    }
}
