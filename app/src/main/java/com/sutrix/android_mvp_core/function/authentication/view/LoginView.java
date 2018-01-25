package com.sutrix.android_mvp_core.function.authentication.view;

import core.model.BaseResult;
import core.view.BaseView;

/**
 * Created by luantruong on 7/12/17.
 */

public interface LoginView extends BaseView {
    void loginFailed(BaseResult failed);

    void loginSuccess(BaseResult success);
}
