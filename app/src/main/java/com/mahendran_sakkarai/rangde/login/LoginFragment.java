package com.mahendran_sakkarai.rangde.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahendran_sakkarai.rangde.BaseFragment;
import com.mahendran_sakkarai.rangde.BasePresenter;
import com.mahendran_sakkarai.rangde.R;
import com.mahendran_sakkarai.rangde.register.RegistrationFragment;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {
    public static Fragment getInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_view, container, false);

        TextView signUp = (TextView) v.findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityContract.showFragment(RegistrationFragment.getInstance(), false);
            }
        });

        return v;
    }

    @Override
    public BasePresenter getPresenter() {
        return new LoginPresenter(this);
    }
}
