package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddStatus;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForApplyLeave;
import com.leeway.athirapb.Activity.Model.AddNoti.AddNotification;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.leeway.athirapb.Activity.Activity.AddNotification;

/**
 * Created by user on 8/30/2017.
 */

public class HttpRequestForAddStatus {
    private static final String TAG = HttpRequestForAddStatus.class.getSimpleName();
    OnHttpResponceForAddStatus onHttpResponceForLogin;



    public HttpRequestForAddStatus(OnHttpResponceForAddStatus onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }

    public void ApplyLeave(String s, String s1, String s2, String userId) {


        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<AddNotification> call = apiInterfaces.AddStatus(userId,s,s1,s2);
        call.enqueue(new Callback<AddNotification>() {
            @Override
            public void onResponse(Call<AddNotification> call, Response<AddNotification> response)
            {
                String res=response.message();
                String ress=response.raw().toString();
                Log.e(TAG, "onResponse: "+res );
                Log.e(TAG, "onResponse: "+ress );

                if(res.equals("OK")) {

                    String code=response.body().getStatus().getCode().toString();
                    Log.e(TAG, "onResponse: "+code );
                    String userid;

                    if (code.equals("200")) {


                        onHttpResponceForLogin.AddAddStatusSuccessTrue("Success",true);








                    } else {
                        onHttpResponceForLogin.AddAddStatusSuccessTrue("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForLogin.AddAddStatusSuccessTrue("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<AddNotification> call, Throwable t) {

                onHttpResponceForLogin.AddAddStatusFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.getMessage() );

            }
        });


    }

}
