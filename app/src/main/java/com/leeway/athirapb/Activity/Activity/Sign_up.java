package com.leeway.athirapb.Activity.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.golovin.fluentstackbar.FluentSnackbar;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForLogin;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForUser;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForUser;
import com.leeway.athirapb.Activity.MainActivity;
import com.leeway.athirapb.Activity.Model.Code;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

/**
 * Created by user on 8/18/2017.
 */

public class Sign_up extends AppCompatActivity implements OnHttpResponceForUser {

    EditText username,password,mobile,email;
    Button sgnup;
    SessionManager sessionManager;
    private FluentSnackbar mFluentSnackbar;
    ProgressDialog progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        mobile = (EditText) findViewById(R.id.mob);
        email = (EditText) findViewById(R.id.email);
        mFluentSnackbar = FluentSnackbar.create(this);
        progressBar = new ProgressDialog(this,
                ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(false);
        progressBar.setMessage("Signing up...");
        progressBar.setCancelable(false);

        sessionManager=new SessionManager(this);
        progressBar.cancel();
        sgnup= (Button) findViewById(R.id.signup);
        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String usrname = username.getText().toString();
                String paswrd = password.getText().toString();
                String phone = mobile.getText().toString();
//                if(!sessionManager.getUsername().equals('1')&&!sessionManager.getEmail().equals('1')&&!sessionManager.getPhone().equals('1')&&!sessionManager.getUserId().equals('1')){
//
//                }
                validation(mail, usrname, paswrd, phone);
            }
        });

            }



    public void validation(String mail,String usrname,String paswrd,String phone)
    {
        if(mail.isEmpty())
        {
            email.setFocusable(true);
            email.setError("error");
            Toast.makeText(Sign_up.this,"fail", Toast.LENGTH_LONG).show();
        }
//        else if
//        {
//
//        }
        else if(usrname.isEmpty())
        {
            username.setFocusable(true);
            username.setError("error");
            Toast.makeText(Sign_up.this,"fail",Toast.LENGTH_LONG).show();
        }
        else if(paswrd.isEmpty())
        {
            password.setFocusable(true);
            password.setError("error");
            Toast.makeText(Sign_up.this,"fail",Toast.LENGTH_LONG).show();
    }
        else if(phone.isEmpty())
        {
            mobile.setFocusable(true);
            mobile.setError("error");
            Toast.makeText(Sign_up.this,"fail",Toast.LENGTH_LONG).show();
        }
        else
        {
            username.setError(null);
            password.setError(null);
            email.setError(null);
            mobile.setError(null);
//            Intent intent=new Intent(Sign_up.this,Sign_in.class);
//            startActivity(intent);
            Toast.makeText(Sign_up.this,"login",Toast.LENGTH_LONG).show();

            progressBar.show();
            HttpRequestForUser httpRequestForUser=new HttpRequestForUser(this);
            httpRequestForUser.AttemtToUser(mail,usrname,paswrd,phone);
        }

    }

    @Override
    public void OnLoginSuccess(String stautus, Boolean success) {
        progressBar.cancel();
        mFluentSnackbar.create("Sign up failed")
                .maxLines(2) // default is 1 line
                .backgroundColorRes(R.color.red_500) // default is #323232
                .textColorRes(R.color.white) // default is Color.WHITE
                .duration(Snackbar.LENGTH_SHORT) // default is Snackbar.LENGTH_LONG
                .actionTextColorRes(R.color.colorAccent)
                .important()
                .show();

    }

    @Override
    public void OnLoginFaild(Throwable throwable) {
        progressBar.cancel();
        mFluentSnackbar.create("Sign up failed")
                .maxLines(2) // default is 1 line
                .backgroundColorRes(R.color.red_500) // default is #323232
                .textColorRes(R.color.white) // default is Color.WHITE
                .duration(Snackbar.LENGTH_SHORT) // default is Snackbar.LENGTH_LONG
                .actionTextColorRes(R.color.colorAccent)
                .important()
                .show();

    }

    @Override
    public void OnLoginSuccessTrue(String success, boolean b, Code code) {
        progressBar.cancel();
        if(b)
        {
            Log.e("username: ",username.getText().toString() );
            Log.e("password: ",password.getText().toString() );
            Log.e("email:",email.getText().toString());
            Log.e("phone:",mobile.getText().toString());
            //Log.e("id:",id)
//            sessionManager.SaveCredentials(username.getText().toString(),password.getText().toString());
            // sessionManager.SaveUseId(code.getUserId().toString());
//            sessionManager.SaveRole(code.get(0).getRole());


            Intent intent=new Intent(this,Sign_in.class);
            startActivity(intent);
            finish();
        }
        else

        {

            mFluentSnackbar.create(success)
                    .maxLines(2) // default is 1 line
                    .backgroundColorRes(R.color.red_500) // default is #323232
                    .textColorRes(R.color.white) // default is Color.WHITE
                    .duration(Snackbar.LENGTH_SHORT) // default is Snackbar.LENGTH_LONG
                    .actionTextColorRes(R.color.colorAccent)
                    .important()
                    .show();
        }


    }
}

