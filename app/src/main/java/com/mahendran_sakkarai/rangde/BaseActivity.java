package com.mahendran_sakkarai.rangde;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mahendran_sakkarai.rangde.login.LoginFragment;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public class BaseActivity extends AppCompatActivity implements ActivityContract {
    private FragmentManager mFragmentManager;
    private Fragment mActiveFragment;
    private BasePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // InitializeFragment
        mFragmentManager = getSupportFragmentManager();
        mActiveFragment = mFragmentManager.findFragmentById(R.id.container);

        if (savedInstanceState == null || mActiveFragment == null) {
            mActiveFragment = LoginFragment.getInstance();
            showFragment(mActiveFragment, true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mActiveFragment != null)
            // Setting the activity contract instance to the fragment.
            ((BaseView) mActiveFragment).setActivityContract(this);
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager != null && mFragmentManager.getBackStackEntryCount() > 1) {
            closeActiveFragment();
        } else if (mFragmentManager != null && mFragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showFragment(Fragment fragment, boolean isClearPrevious) {
        if (mFragmentManager != null) {
            // To Clear all fragments from the stack
            if (isClearPrevious && mFragmentManager.getBackStackEntryCount() > 0) {
                mFragmentManager.popBackStack(R.id.container,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }

            if (fragment != null) {
                mActiveFragment = fragment;
                // Setting the activity contract instance to the fragment.
                ((BaseView)mActiveFragment).setActivityContract(this);
                // Replacing the view and fragment with the new one.
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, mActiveFragment, mActiveFragment.getClass().getName())
                        .addToBackStack(mActiveFragment.getClass().getName())
                        .commit();
            }
        }
    }

    @Override
    public void closeActiveFragment() {
        if (mFragmentManager != null && mFragmentManager.getBackStackEntryCount() > 0)
            mFragmentManager.popBackStack();
    }

    @Override
    public void goBack() {
        onBackPressed();
    }
}
