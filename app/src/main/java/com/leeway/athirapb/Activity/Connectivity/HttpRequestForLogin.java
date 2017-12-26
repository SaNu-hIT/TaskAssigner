package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

//import com.leeway.athirapb.Activity.Activity.Status;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForLogin;
import com.leeway.athirapb.Activity.Model.Code;
import com.leeway.athirapb.Activity.Model.LoginStatus;
import com.leeway.athirapb.Activity.Model.Status;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 8/30/2017.
 */

public class HttpRequestForLogin {
    private static final String TAG = HttpRequestForLogin.class.getSimpleName();
    OnHttpResponceForLogin onHttpResponceForLogin;



    public HttpRequestForLogin(OnHttpResponceForLogin onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }

    public void AttemtToLogin(final String username, final String password) {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<LoginStatus> call = apiInterfaces.loginUser(username, password);
        call.enqueue(new Callback<LoginStatus>() {
            @Override
            public void onResponse(Call<LoginStatus> call, Response<LoginStatus> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Status status = response.body().getStatus();
                    Long code=status.getCode();
                    Log.e(TAG, "onResponse: "+status);
                    String userid;

                    if (code==200) {

                        Code code1= response.body().getCode();
                        onHttpResponceForLogin.OnLoginSuccessTrue("Login success", true,code1);








                    } else {
                        onHttpResponceForLogin.OnLoginSuccess("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForLogin.OnLoginSuccess("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<LoginStatus> call, Throwable t) {

                onHttpResponceForLogin.OnLoginFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }

}
