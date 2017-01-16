package com.mahendran_sakkarai.rangde.register;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter {
    private final RegistrationContract.View mView;

    public RegistrationPresenter(RegistrationContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {

    }
}
