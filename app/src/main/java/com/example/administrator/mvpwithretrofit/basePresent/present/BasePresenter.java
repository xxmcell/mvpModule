package com.example.administrator.mvpwithretrofit.basePresent.present;


import com.example.administrator.mvpwithretrofit.basePresent.view.BaseView;

public abstract class BasePresenter<T extends BaseView> {
    public T mvpView;

    /**
     * 方法功能：当P创建的时候 把view也创建
     */
    public void onCreate(T mvpView) {
        this.mvpView = mvpView;
    }

    /**
     * 方法功能：销毁
     */
    public void onDestroy() {
        mvpView = null;
    }

    /**
     * 方法功能：销毁
     */
    public void onLowMemory() {
        mvpView = null;
    }

    /**
     * 注释说明: 返回值提示信息
     */
//    public void showMsg(BaseHttpResponse result) {
//        if (result.isSucceed()) {
//            mvpView.showErrorSnackbar(result.getMsg());
//        } else {
//            mvpView.showWarningSnackbar(result.getMsg());
//        }
//    }
//
//    public void addPageData(Map<String, String> map) {
//        if (mvpView instanceof BaseListView) {
//            map.put("Pageindex", String.valueOf(((BaseListView) mvpView).getPageindex()));
//            map.put("PageCount", String.valueOf(((BaseListView) mvpView).getPageCount()));
//        }
//    }
}
