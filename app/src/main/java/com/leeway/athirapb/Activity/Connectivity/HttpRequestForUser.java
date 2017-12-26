package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForLogin;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForUser;
import com.leeway.athirapb.Activity.Model.Code;
import com.leeway.athirapb.Activity.Model.CreateUser;
import com.leeway.athirapb.Activity.Model.LoginStatus;
import com.leeway.athirapb.Activity.Model.Status;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/8/2017.
 */

public class HttpRequestForUser {
    private static final String TAG = HttpRequestForLogin.class.getSimpleName();
    OnHttpResponceForUser onHttpResponceForUser;



    public HttpRequestForUser(OnHttpResponceForUser onHttpResponceForUser) {
        this.onHttpResponceForUser =  onHttpResponceForUser;
    }

    public void AttemtToUser(final String mail, final String username,final String password, final String phone) {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<CreateUser> call = apiInterfaces.createusers(mail,username, password,phone);
        call.enqueue(new Callback<CreateUser>() {
            @Override
            public void onResponse(Call<CreateUser> call, Response<CreateUser> response)
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
                        onHttpResponceForUser.OnLoginSuccessTrue("Login success", true,code1);








                    } else {
                        onHttpResponceForUser.OnLoginSuccess("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForUser.OnLoginSuccess("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<CreateUser> call, Throwable t) {

                onHttpResponceForUser.OnLoginFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }

}
