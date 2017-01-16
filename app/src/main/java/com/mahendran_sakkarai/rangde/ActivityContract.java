package com.mahendran_sakkarai.rangde;

import android.support.v4.app.Fragment;

/**
 * Created by Mahendran Sakkarai on 16-01-2017.
 */

public interface ActivityContract {
    void setPresenter(BasePresenter presenter);

    void showFragment(Fragment fragment, boolean isClearPrevious);

    void closeActiveFragment();

    void goBack();
}
