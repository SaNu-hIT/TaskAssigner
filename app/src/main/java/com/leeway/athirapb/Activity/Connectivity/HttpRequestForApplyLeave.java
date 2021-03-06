package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddNotification;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForApplyLeave;
import com.leeway.athirapb.Activity.Model.AddNoti.AddNotification;
import com.leeway.athirapb.Activity.Model.SendJson.SendTickets;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.leeway.athirapb.Activity.Activity.AddNotification;

/**
 * Created by user on 8/30/2017.
 */

public class HttpRequestForApplyLeave {
    private static final String TAG = HttpRequestForApplyLeave.class.getSimpleName();
    OnHttpResponceForApplyLeave onHttpResponceForLogin;



    public HttpRequestForApplyLeave(OnHttpResponceForApplyLeave onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }

    public void ApplyLeave(String userId,String leave_desc,String leave_date,String joining_date, String leave_days) {


        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<AddNotification> call = apiInterfaces.AddLeave(userId,leave_desc,leave_date,joining_date,leave_days);
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


                        onHttpResponceForLogin.AddApplyLeaveSuccessTrue("Success",true);








                    } else {
                        onHttpResponceForLogin.AddApplyLeaveSuccessTrue("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForLogin.AddApplyLeaveSuccessTrue("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<AddNotification> call, Throwable t) {

                onHttpResponceForLogin.AddApplyLeaveFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.getMessage() );

            }
        });


    }

}
