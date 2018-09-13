package com.example.administrator.mvpwithretrofit.mode;

public class ApiConstants {


    public static final int TYPE_TEST_HOST_RUL = 2;

    public static String BASE_TEST = "";
    /**
     * 获取对应的host
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host = null;
        switch (hostType) {
            case TYPE_TEST_HOST_RUL:
                host = BASE_TEST;
                break;
        }
        return host;
    }
}
