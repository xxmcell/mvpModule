package com.example.administrator.mvpwithretrofit.mode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2018/1/19/019.
 */

public class GsonHelp {
    public static Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(int.class, new JsonTypeAdapter.IntegerTypeAdapter())
                .registerTypeAdapter(long.class, new JsonTypeAdapter.LongTypeAdapter())
                .registerTypeAdapter(float.class, new JsonTypeAdapter.FloatTypeAdapter())
                .registerTypeAdapter(double.class, new JsonTypeAdapter.DoubleTypeAdapter())
                .serializeNulls()
                .create();
    }
}
