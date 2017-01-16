package com.mahendran_sakkarai.rangde.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahendran_sakkarai.rangde.BaseFragment;
import com.mahendran_sakkarai.rangde.BasePresenter;
import com.mahendran_sakkarai.rangde.R;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public class RegistrationFragment extends BaseFragment implements RegistrationContract.View{
    public static Fragment getInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public BasePresenter getPresenter() {
        return new RegistrationPresenter(this);
    }
}
