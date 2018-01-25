package core.data.services;

import com.sutrix.android_mvp_core.function.authentication.data.LoginModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by luantruong on 7/12/17.
 */

public interface APIService {

    @POST("/api/login")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> getLoginResult(@Body LoginModel loginModel);
}
