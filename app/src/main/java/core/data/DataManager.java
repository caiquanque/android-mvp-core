package core.data;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.sutrix.android_mvp_core.function.authentication.data.LoginModel;
import com.sutrix.android_mvp_core.function.authentication.data.LoginResult;
import com.sutrix.android_mvp_core.utils.APIUtils;

import core.model.BaseModel;
import core.model.BaseResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luantruong on 7/25/17.
 */

public class DataManager {

    public static void makeRequest(final WSRequestCallback callback, final RequestTarget target, BaseModel... model) {
        if (target == null || callback == null) return;
        Call<ResponseBody> request = RequestTarget.getTarget(target, model);
        if (request == null) {
            callback.onFail(target, "");
            return;
        }
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                BaseResult result = parseResult(response, target);
                if (response.isSuccessful()) {
                    callback.onResultSuccess(result, target);
                } else {
                    callback.onResultFail(result, target);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                callback.onFail(target, t.getMessage());

            }
        });
    }

    public interface WSRequestCallback {
        void onResultSuccess(BaseResult result, RequestTarget target);

        void onResultFail(BaseResult failed, RequestTarget target);

        void onFail(RequestTarget target, String error);

    }

    public enum RequestTarget {
        LOGIN;

        public static Call<ResponseBody> getTarget(RequestTarget target, BaseModel... model) {
            switch (target) {
                case LOGIN:
                    if (model.length == 0) return null;
                    return APIUtils.getAPIService().getLoginResult((LoginModel) model[0]);
            }
            return null;
        }
    }

    private static BaseResult parseResult(Response<ResponseBody> rawResponse, RequestTarget target) {

        switch (target) {
            case LOGIN:
                LoginResult result = new LoginResult();
                try {
                    result = new Gson().fromJson(rawResponse.body().string(), LoginResult.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result.setResponseCode(rawResponse.code());
                return result;

        }

        return null;
    }
}
