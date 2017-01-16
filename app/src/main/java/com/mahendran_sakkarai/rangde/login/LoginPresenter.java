package com.mahendran_sakkarai.rangde.login;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {

    }
}
