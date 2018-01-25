package com.sutrix.android_mvp_core.function.authentication.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sutrix.android_mvp_core.R;
import com.sutrix.android_mvp_core.R2;
import com.sutrix.android_mvp_core.function.authentication.data.LoginModel;
import com.sutrix.android_mvp_core.function.authentication.data.LoginResult;
import com.sutrix.android_mvp_core.function.authentication.presenter.LoginPresenter;
import com.sutrix.android_mvp_core.function.authentication.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;
import core.model.BaseResult;
import core.presenter.loader.PresenterFactory;
import core.view.impl.BaseMVPActivity;

/**
 * View extends @BaseMVPActivity must have both presenter and view, also implement View interface
 */
public class LoginActivity extends BaseMVPActivity<LoginPresenter, LoginView> implements LoginView {

    @BindView(R2.id.username)
    EditText mUsername;
    @BindView(R2.id.password)
    EditText mPassword;
    @BindView(R2.id.signin)
    Button mSignIn;
    PresenterFactory<LoginPresenter> mPresenterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R2.id.signin)
    void login() {
        if (mPresenter != null) {
            String username = mUsername.getText().toString();
            String pwd = mPassword.getText().toString();
            mPresenter.doLogin(new LoginModel(username, pwd));
        }
    }

    @Override
    protected PresenterFactory<LoginPresenter> getPresenterFactory() {
        mPresenterFactory = new PresenterFactory<LoginPresenter>() {
            @NonNull
            @Override
            public LoginPresenter create() {
                return new LoginPresenterImpl();
            }
        };
        return mPresenterFactory;
    }

    @Override
    public void loginFailed(BaseResult failed) {

    }

    @Override
    public void loginSuccess(BaseResult success) {
        if (success instanceof LoginResult) {
            Toast.makeText(this, "Login token: " + ((LoginResult) success).getToken(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showLoader() {

    }
}
