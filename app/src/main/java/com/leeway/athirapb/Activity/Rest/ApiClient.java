package com.leeway.athirapb.Activity.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class ApiClient {
    public static final String BASE_URL="http://www.leewaylabs.com/AThira/v1/";
    public static Retrofit retrofit=null;
    public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
