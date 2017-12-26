package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;


import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.Message;
import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.StatusBeanList;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListLeave;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListStatus;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForListStatus {
    private static final String TAG = HttpRequestForListStatus.class.getSimpleName();
    OnHttpResponceListStatus onHttpResponceProject;



    public HttpRequestForListStatus(OnHttpResponceListStatus onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void GetLeave() {



        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<StatusBeanList> call = apiInterfaces.getStatus();

        call.enqueue(new Callback<StatusBeanList>() {
            @Override
            public void onResponse(Call<StatusBeanList> call, Response<StatusBeanList> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    String status = response.body().getStatus().getCode().toString();
                    Log.e(TAG, "error: "+status);
                    String userid;

                    if (status.equals("200")) {
                        List<Message> projectInfo=response.body().getMessage();
                        Log.e(TAG, "onResponse: "+projectInfo.toString() );
                        if(projectInfo.size()==0) {
                            onHttpResponceProject.OnListStatusFaild("Nodata");
                        }else
                        {
                            onHttpResponceProject.OnListStatusSuccessTrue("success",true,projectInfo);
                        }


                    } else {


                    }
                }
                else
                {

                    onHttpResponceProject.OnListStatusFaild("failed");


                }

            }

            @Override
            public void onFailure(Call<StatusBeanList> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnListStatusFaild("error api call");
            }
        });


    }

}
