package com.example.administrator.mvpwithretrofit.mode;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;

import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 */

public class BaseHttpRequest {

    //切换网络访问地址
    public static final int TYPE_TEST_HOST_RUL = 2;

    private static String BASE_URL= ApiConstants.getHost(TYPE_TEST_HOST_RUL);

    public static BaseServiceApi baseServiceApi;

    private static BaseHttpRequest baseHttpRequest;

    private static String urlPath;

    public static BaseHttpRequest getInstance(String path){
        urlPath=path;
        if(baseHttpRequest==null){
            baseHttpRequest=new BaseHttpRequest();
            return baseHttpRequest;
        }
        return baseHttpRequest;
    }

    /**
     * 监听和订阅的连接
     */
    static Observable.Transformer schedulersTransformer =                                                                                                                                                        new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable).subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io()).throttleFirst(500, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    /**
     * 订阅
     * @param observable 被监听者，相当于网络访问
     * @param subscriber 监听者，  相当于回调监听
     */
    public static <T> Subscription toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        return observable.compose(schedulersTransformer)
                .subscribe(subscriber);
    }
    /**
     * 接受对象的重载方法
     * @param subscriber
     * @param data
     * @param <T>
     */
    public static <T> void ExecutionJson(final HttpCallBack<T> subscriber, Object data){

        Gson gson = new Gson();

        String json = gson.toJson(data);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        baseServiceApi = getRetrofit().create(BaseServiceApi.class);

        toSubscribe(baseServiceApi.executePost(urlPath,requestBody),
                new HttpSubscription(subscriber));
    }


    //基础retrofit
    private static Retrofit getRetrofit(){
         return new  Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create(GsonHelp.getGson())).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                baseUrl(BASE_URL).
                 //添加请求头
                 //        client(getOkHttpClientType()).
                build();

    }
    //添加请求头
    private static OkHttpClient getOkHttpClientType() {
        //在需要时,添加拦截
        final OkHttpClient builder = getRetrofitBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request;
                    request = chain.request().newBuilder().build();

                Request NewRequest=chain.request();
                //获取url,作为hashmap的键
                String UrlKey=NewRequest.url().encodedPath();

                return chain.proceed(request);
            }
        }).build();
        return builder;
    }

    //默认的超时时间
    private static final int DEFAULT_TIMEOUT = 30;

    public static OkHttpClient.Builder getRetrofitBuilder() {
        //1：手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true);//链接失败重新链接
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//链接超时
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//读取超时
        builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//写入超时
        //设置缓存目录
//        File cacheDirectory = new File(XFQ2CAppApplication.appSDCachePath, "HttpCache");
//        final Cache cache = new Cache(cacheDirectory, 50 * 1024 * 1024);//
//        builder.cache(cache);//设置缓存
        return builder;
    }
}
