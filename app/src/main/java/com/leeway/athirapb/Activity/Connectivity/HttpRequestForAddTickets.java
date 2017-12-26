package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddNotification;
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

public class HttpRequestForAddTickets {
    private static final String TAG = HttpRequestForAddTickets.class.getSimpleName();
    OnHttpResponceForAddNotification onHttpResponceForLogin;



    public HttpRequestForAddTickets(OnHttpResponceForAddNotification onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }

    public void AddTickets(final SendTickets message) {

        Log.e(TAG, "message: "+message.getAssignDate().toString() );
        Log.e(TAG, "message: "+message.getTicketDesc().toString() );
        Log.e(TAG, "message: "+message.toString() );

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<AddNotification> call = apiInterfaces.AddTickets(message);
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


                        onHttpResponceForLogin.AddNotificationSuccessTrue("Success",true);








                    } else {
                        onHttpResponceForLogin.AddNotificationSuccessTrue("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForLogin.AddNotificationSuccessTrue("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<AddNotification> call, Throwable t) {

                onHttpResponceForLogin.AddNotificationFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.getMessage() );

            }
        });


    }

}
