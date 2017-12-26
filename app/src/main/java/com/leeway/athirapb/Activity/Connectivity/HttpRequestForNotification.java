package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceNotification;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceTickets;

import com.leeway.athirapb.Activity.Model.Notification.Notification;
import com.leeway.athirapb.Activity.Model.Notification.Notificatios;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForNotification {
    private static final String TAG = HttpRequestForNotification.class.getSimpleName();
    OnHttpResponceNotification onHttpResponceProject;



    public HttpRequestForNotification(OnHttpResponceNotification onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void getNoticiation() {


        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<Notificatios> call = apiInterfaces.getNotification();

        call.enqueue(new Callback<Notificatios>() {
            @Override
            public void onResponse(Call<Notificatios> call, Response<Notificatios> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    String status = response.body().getStatus().getCode().toString();
                    Log.e(TAG, "error: "+status);
                    String userid;

                    if (status.equals("200")) {
                        List<Notification> projectInfo=response.body().getNotification();

                        onHttpResponceProject.OnNotificationSuccessTrue("success",true,projectInfo);
                    } else {
                        onHttpResponceProject.OnNotificationFail("Nodata");

                    }
                }
                else
                {

                    onHttpResponceProject.OnNotificationFail("failed");


                }

            }

            @Override
            public void onFailure(Call<Notificatios> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnNotificationFail("error api call");
            }
        });


    }

}
