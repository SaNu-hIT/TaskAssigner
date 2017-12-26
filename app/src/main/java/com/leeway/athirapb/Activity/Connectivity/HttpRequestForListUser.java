package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListUser;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceNotification;
import com.leeway.athirapb.Activity.Model.ListUser.ListUserModel;
import com.leeway.athirapb.Activity.Model.ListUser.Userinfo;
import com.leeway.athirapb.Activity.Model.Notification.Notification;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForListUser {
    private static final String TAG = HttpRequestForListUser.class.getSimpleName();
    OnHttpResponceListUser onHttpResponceProject;



    public HttpRequestForListUser(OnHttpResponceListUser onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void getUseList() {


        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<ListUserModel> call = apiInterfaces.getUser();

        call.enqueue(new Callback<ListUserModel>() {
            @Override
            public void onResponse(Call<ListUserModel> call, Response<ListUserModel> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    String status = response.body().getStatus().getCode().toString();
                    Log.e(TAG, "error: "+status);
                    String userid;

                    if (status.equals("200")) {
                        List<Userinfo> projectInfo=response.body().getUserinfo();

                        onHttpResponceProject.OnListUserSuccessTrue("success",true,projectInfo);
                    } else {
                        onHttpResponceProject.OnListUserFail("Nodata");

                    }
                }
                else
                {

                    onHttpResponceProject.OnListUserFail("failed");


                }

            }

            @Override
            public void onFailure(Call<ListUserModel> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnListUserFail("error api call");
            }
        });


    }

}
