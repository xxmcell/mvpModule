package com.example.administrator.mvpwithretrofit.dp;

import com.example.administrator.mvpwithretrofit.MyApplication;
import com.example.administrator.mvpwithretrofit.beans.TestGreenDaoBean;
import com.example.administrator.mvpwithretrofit.beans.TestGreenDaoBeanDao;

import java.util.List;

/**
 * 可以根据具体情况
 * Created by Administrator on 2018/9/13/013.
 */

public class testControl {
    //增
    public static void insertData(TestGreenDaoBean testGreenDaoBean){
        MyApplication.getDaoInstant().getTestGreenDaoBeanDao().insert(testGreenDaoBean);

    //        MyApplication.getDaoInstant().getTestGreenDaoBeanDao().insertOrReplace(testGreenDaoBean);
    }

    //删
    public static void deleteData(Long id){
        MyApplication.getDaoInstant().getTestGreenDaoBeanDao().deleteByKey(id);
    }

    //改
    public static void updata(TestGreenDaoBean testGreenDaoBean){
        MyApplication.getDaoInstant().getTestGreenDaoBeanDao().update(testGreenDaoBean);
    }

    //按照一定条件去查
    public static List<TestGreenDaoBean> queryData(String type){
       return MyApplication.getDaoInstant().getTestGreenDaoBeanDao().queryBuilder().where(TestGreenDaoBeanDao.Properties.Type.eq(type)).list();
    }

    //查看全部数据
    public static List<TestGreenDaoBean> queryAll(){
        return MyApplication.getDaoInstant().getTestGreenDaoBeanDao().loadAll();
    }
}
