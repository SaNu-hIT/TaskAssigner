package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceProject;
import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.Activity.Model.ProjectList;
import com.leeway.athirapb.Activity.Model.Status;
import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForProject {
    private static final String TAG = HttpRequestForProject.class.getSimpleName();
    OnHttpResponceProject onHttpResponceProject;



    public HttpRequestForProject(OnHttpResponceProject onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void getProject(final String userId,final String proid) {


        Log.e(TAG, "userid "+userId );
        Log.e("user",userId);

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<ProjectList> call = apiInterfaces.getProject(userId,proid);
        call.enqueue(new Callback<ProjectList>() {
            @Override
            public void onResponse(Call<ProjectList> call, Response<ProjectList> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Status status = response.body().getStatus();

                    String code=status.getCode().toString();
                    Log.e( "error: ",""+status);
                    String userid;

                    if (code.equals("200")) {
                        List<ProjectInfo> projectInfo=response.body().getProjectInfo();
                        Log.e(TAG, "projectInfo: "+projectInfo.size() );
                        onHttpResponceProject.OnProjectSuccessTrue("success",true,projectInfo);
                    } else {
                        onHttpResponceProject.OnProjectFaild("Nodata");

                    }
                }
                else
                {

                    onHttpResponceProject.OnProjectFaild("failed");


                }

            }

            @Override
            public void onFailure(Call<ProjectList> call, Throwable t) {
                Log.e(TAG, "onFailure:  "+t.getMessage());
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnProjectFaild("Nodata");
            }
        });


    }

}
