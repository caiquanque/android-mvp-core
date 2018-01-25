package com.sutrix.android_mvp_core.function.authentication.presenter;

import com.sutrix.android_mvp_core.function.authentication.data.LoginResult;
import com.sutrix.android_mvp_core.function.authentication.view.LoginView;

import core.data.DataManager;
import core.model.BaseModel;
import core.model.BaseResult;
import core.presenter.impl.BasePresenterImpl;

/**
 * Created by luantruong on 7/12/17.
 */

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter, DataManager.WSRequestCallback {

    @Override
    public void doLogin(BaseModel login) {
        if (mView != null) {
            DataManager.makeRequest(this, DataManager.RequestTarget.LOGIN, login);
        }

    }

    @Override
    public void onResultSuccess(BaseResult result, DataManager.RequestTarget target) {
        if (mView == null) return;
        if (result instanceof LoginResult) {
            mView.loginSuccess(result);
        }

    }

    @Override
    public void onResultFail(BaseResult failed, DataManager.RequestTarget target) {
        if (mView == null) return;
        mView.loginFailed(null);

    }

    @Override
    public void onFail(DataManager.RequestTarget target, String error) {
        if (mView == null) return;
        mView.loginFailed(null);

    }
}
