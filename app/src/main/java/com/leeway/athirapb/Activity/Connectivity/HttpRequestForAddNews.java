package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddNews;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForLogin;
import com.leeway.athirapb.Activity.Model.AddNoti.AddNotification;
import com.leeway.athirapb.Activity.Model.Code;

import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.leeway.athirapb.Activity.Activity.AddNotification;

/**
 * Created by user on 8/30/2017.
 */

public class HttpRequestForAddNews {
    private static final String TAG = HttpRequestForAddNews.class.getSimpleName();
    OnHttpResponceForAddNews onHttpResponceForLogin;



    public HttpRequestForAddNews(OnHttpResponceForAddNews onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }

    public void AddNews(final String message) {
        Log.e(TAG, "message: "+message );

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<AddNotification> call = apiInterfaces.addNews(message);
        call.enqueue(new Callback<AddNotification>() {
            @Override
            public void onResponse(Call<AddNotification> call, Response<AddNotification> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {

                    String code=response.body().getStatus().getCode().toString();
                    Log.e(TAG, "onResponse: "+code );
                    String userid;

                    if (code.equals("200")) {


                        onHttpResponceForLogin.AddNewsSuccessTrue(" success", true);








                    } else {
                        onHttpResponceForLogin.AddNewsSuccess("failure", false);
                    }
                }
                else
                {
                    onHttpResponceForLogin.AddNewsSuccess("Oops Something went wrong", false);


                }

            }

            @Override
            public void onFailure(Call<AddNotification> call, Throwable t) {

                onHttpResponceForLogin.AddNewsFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }

}
