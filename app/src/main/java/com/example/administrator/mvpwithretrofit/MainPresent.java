package com.example.administrator.mvpwithretrofit;

import com.example.administrator.mvpwithretrofit.basePresent.present.BasePresenter;
import com.example.administrator.mvpwithretrofit.mode.BaseHttpRequest;
import com.example.administrator.mvpwithretrofit.mode.HttpCallBack;
import com.google.gson.JsonObject;

/**
 * Created by Administrator on 2018/6/19/019.
 */

public class MainPresent extends BasePresenter<TestInterFace> {
    public void getResoult(){
        HttpCallBack httpCallBack=new HttpCallBack() {
            @Override
            public void onError(Throwable error) {
                super.onError(error);
            }

            @Override
            public void onSuccess(Object result) {
                super.onSuccess(result);
                mvpView.ForResoult();
            }
        };
        JsonObject object=new JsonObject();
        BaseHttpRequest.getInstance("/open/areaList").ExecutionJson(httpCallBack,object);
    }
}
