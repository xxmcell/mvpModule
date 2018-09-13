package com.example.administrator.mvpwithretrofit;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.administrator.mvpwithretrofit.beans.DaoMaster;
import com.example.administrator.mvpwithretrofit.beans.DaoSession;

/**
 * Created by Administrator on 2018/9/12/012.
 */

public class MyApplication extends Application {

    public static Context mContext;

    public  static MyApplication mInstance;

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();

        mInstance=this;

        setUpGreenDao();
    }

    private void setUpGreenDao() {
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(mContext,"Green_dao",null);

        SQLiteDatabase dp=helper.getWritableDatabase();

        DaoMaster daoMaster=new DaoMaster(dp);

        daoSession = daoMaster.newSession();
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public static Context getContent(){
        return mContext;
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

}
