package com.example.administrator.mvpwithretrofit.basePresent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.administrator.mvpwithretrofit.basePresent.present.BasePresenter;
import com.example.administrator.mvpwithretrofit.basePresent.view.BaseView;

public abstract class BaseMvpFragment<V extends BaseView, T extends BasePresenter<V>> extends Fragment {

    public T presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPressenter();
        if (presenter != null) {
            presenter.onCreate((V) this);
        }
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        if (presenter != null) {
            presenter.onLowMemory();
        }
        super.onLowMemory();
    }

    /**
     * 实例化Presenter对象
     *
     * @return
     */
    public abstract T initPressenter();
}
