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
<<<<<<< HEAD
        //对应的可以在HttpCallBack<>中写入对应需要解析的数据模型,对应的下面返回的就是写入的mvp模型
=======
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac
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
<<<<<<< HEAD
        BaseHttpRequest.getInstance("").ExecutionJson(httpCallBack,object);
=======
        BaseHttpRequest.getInstance("/open/areaList").ExecutionJson(httpCallBack,object);
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac
    }
}
