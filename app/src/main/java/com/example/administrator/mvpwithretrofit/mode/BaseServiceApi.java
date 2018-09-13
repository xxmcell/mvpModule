package com.example.administrator.mvpwithretrofit.mode;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * **
 * 创建时间:2016/9/24　16:02
 *
 * <p>
 * 功能介绍：基本请求方式的服务器接口
 */

public interface BaseServiceApi {

    /**
     * **
     * 创建时间: 2016/9/24 16:12
     * <p>
     * 方法功能：post请求
     *

     */

    @POST("{path}")
    Observable<ResponseBody> executePost(
            @Path(value = "path", encoded = true) String path,
            @Body RequestBody param
    );

}
