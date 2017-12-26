package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Fragment.LeaveListing.LeaveListStatus;
import com.leeway.athirapb.Activity.Fragment.LeaveListing.Message;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListLeave;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceTickets;

import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForListLeave {
    private static final String TAG = HttpRequestForListLeave.class.getSimpleName();
    OnHttpResponceListLeave onHttpResponceProject;



    public HttpRequestForListLeave(OnHttpResponceListLeave onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void GetLeave() {



        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<LeaveListStatus> call = apiInterfaces.getLeave();

        call.enqueue(new Callback<LeaveListStatus>() {
            @Override
            public void onResponse(Call<LeaveListStatus> call, Response<LeaveListStatus> response)
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
                            onHttpResponceProject.OnListLeaveFaild("Nodata");
                        }else
                        {
                            onHttpResponceProject.OnListLeaveSuccessTrue("success",true,projectInfo);
                        }


                    } else {


                    }
                }
                else
                {

                    onHttpResponceProject.OnListLeaveFaild("failed");


                }

            }

            @Override
            public void onFailure(Call<LeaveListStatus> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnListLeaveFaild("error api call");
            }
        });


    }

}
