package com.mahendran_sakkarai.rangde;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView {
    protected ActivityContract mActivityContract;
    private BasePresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mPresenter = getPresenter();
        mActivityContract.setPresenter(mPresenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public abstract BasePresenter getPresenter();

    @Override
    public void setActivityContract(ActivityContract contract) {
        this.mActivityContract = contract;
    }
}
