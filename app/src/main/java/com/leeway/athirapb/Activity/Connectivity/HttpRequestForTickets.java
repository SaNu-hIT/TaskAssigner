package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceProject;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceTickets;


import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;
import com.leeway.athirapb.Activity.Model.Tickets.Tickets;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForTickets {
    private static final String TAG = HttpRequestForTickets.class.getSimpleName();
    OnHttpResponceTickets onHttpResponceProject;



    public HttpRequestForTickets(OnHttpResponceTickets onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void getTickets(final String userId,String open) {


        Log.e(TAG, "userid "+userId );
        Log.e("user",userId);

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<Tickets> call = apiInterfaces.getTickets(userId,open);

        call.enqueue(new Callback<Tickets>() {
            @Override
            public void onResponse(Call<Tickets> call, Response<Tickets> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    String status = response.body().getStatus().getCode().toString();
                    Log.e(TAG, "error: "+status);
                    String userid;

                    if (status.equals("200")) {
                        List<TicketInfo> projectInfo=response.body().getTicketInfo();

                        onHttpResponceProject.OnTicketsSuccessTrue("success",true,projectInfo);
                    } else {
                        onHttpResponceProject.OnTicketsFaild("Nodata");

                    }
                }
                else
                {

                    onHttpResponceProject.OnTicketsFaild("failed");


                }

            }

            @Override
            public void onFailure(Call<Tickets> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnTicketsFaild("error api call");
            }
        });


    }

}
