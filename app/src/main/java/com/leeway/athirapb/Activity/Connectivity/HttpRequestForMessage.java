package com.leeway.athirapb.Activity.Connectivity;

import android.util.Log;

import com.leeway.athirapb.Activity.Fragment.Messages.dummy.Message;
import com.leeway.athirapb.Activity.Fragment.Messages.dummy.MessageBean;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceMessage;


import com.leeway.athirapb.Activity.Rest.ApiClient;
import com.leeway.athirapb.Activity.Rest.ApiInterfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 9/12/2017.
 */

public class HttpRequestForMessage {
    private static final String TAG = HttpRequestForMessage.class.getSimpleName();
    OnHttpResponceMessage onHttpResponceProject;



    public HttpRequestForMessage(OnHttpResponceMessage onHttpResponceProject) {
        this.onHttpResponceProject = onHttpResponceProject;
    }

    public void getMessage(final String userId,String open) {


        Log.e(TAG, "userid "+userId );
        Log.e("user",userId);


        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<MessageBean> call = apiInterfaces.getMessage(userId);

        call.enqueue(new Callback<MessageBean>() {
            @Override
            public void onResponse(Call<MessageBean> call, Response<MessageBean> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    String status = response.body().getStatus().getCode().toString();
                    Log.e(TAG, "error: "+status);
                    String userid;

                    if (status.equals("200")) {
                        List<Message> projectInfo=response.body().getMessage();

                        onHttpResponceProject.OnMessageSuccessTrue("success",true,projectInfo);
                    } else {
                        onHttpResponceProject.OnMessageFaild("Nodata");

                    }
                }
                else
                {

                    onHttpResponceProject.OnMessageFaild("failed");
                    Log.e(TAG, "onResponse: "+"faild" );

                }

            }

            @Override
            public void onFailure(Call<MessageBean> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t );
//                onHttpResponceCategory.OnCatgoryFaild("Network Error");
                onHttpResponceProject.OnMessageFaild("error api call");
            }
        });


    }

}
