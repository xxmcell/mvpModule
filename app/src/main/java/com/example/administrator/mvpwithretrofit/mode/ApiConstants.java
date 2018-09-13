package com.example.administrator.mvpwithretrofit.mode;

public class ApiConstants {


    public static final int TYPE_TEST_HOST_RUL = 2;

<<<<<<< HEAD
    public static String BASE_TEST = "";
=======
    public static String BASE_TEST = "http://testservice.dripop.com";
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac
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
