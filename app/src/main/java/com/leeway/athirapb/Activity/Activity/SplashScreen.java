package com.leeway.athirapb.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leeway.athirapb.Activity.MainActivity;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

/**
 * Created by user on 9/8/2017.
 */

public class SplashScreen extends AppCompatActivity {
    public static final int TIME_OUT=3000;
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        sessionManager=new SessionManager(this);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                if(sessionManager.getUsername().equals("1"))
                {
                    Intent intent=new Intent(getBaseContext(),Sign_in.class);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    if(sessionManager.getRole().equals("1"))
                    {
                        Intent intent=new Intent(getBaseContext(),Admin.class);
                        startActivity(intent);
                        finish();
                    }else
                    {
                        Intent intent=new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }


            }
        },TIME_OUT);

    }
}
