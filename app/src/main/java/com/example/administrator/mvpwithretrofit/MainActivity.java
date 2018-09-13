package com.example.administrator.mvpwithretrofit;

import android.os.Bundle;
<<<<<<< HEAD
import com.example.administrator.mvpwithretrofit.basePresent.activity.BaseMvpActivity;

=======
import android.widget.TextView;

import com.example.administrator.mvpwithretrofit.basePresent.activity.BaseMvpActivity;
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac

public class MainActivity extends BaseMvpActivity<TestInterFace,MainPresent> implements TestInterFace{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD

        setContentView(R.layout.activity_main);

        presenter.getResoult();

=======
        setContentView(R.layout.activity_main);

        presenter.getResoult();
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac
    }

    @Override
    public MainPresent initPressenter() {
        return new MainPresent();
    }

    @Override
    public void ForResoult() {
<<<<<<< HEAD

=======
        //回调的结果
>>>>>>> c7aff1bccd9dcb03a22334c62aa7cda154c351ac
    }
}
