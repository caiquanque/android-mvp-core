package com.sutrix.android_mvp_core.function.authentication.presenter;

import com.sutrix.android_mvp_core.function.authentication.view.LoginView;

import core.model.BaseModel;
import core.presenter.Presenter;

/**
 * Created by luantruong on 7/12/17.
 */

public interface LoginPresenter extends Presenter<LoginView> {
    void doLogin(BaseModel login);
}
