package com.example.administrator.mvpwithretrofit;

import android.os.Bundle;
import com.example.administrator.mvpwithretrofit.basePresent.activity.BaseMvpActivity;


public class MainActivity extends BaseMvpActivity<TestInterFace,MainPresent> implements TestInterFace{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        presenter.getResoult();

    }

    @Override
    public MainPresent initPressenter() {
        return new MainPresent();
    }

    @Override
    public void ForResoult() {

    }
}
