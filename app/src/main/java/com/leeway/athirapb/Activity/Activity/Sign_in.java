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
import android.widget.TextView;
import android.widget.Toast;

import com.golovin.fluentstackbar.FluentSnackbar;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForLogin;
import com.leeway.athirapb.Activity.Fragment.DashBoard.DashBoardFragment;
import com.leeway.athirapb.Activity.Fragment.DashBoardMain.DashFragments;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForLogin;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForUser;
import com.leeway.athirapb.Activity.MainActivity;
import com.leeway.athirapb.Activity.Model.Code;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import static com.leeway.athirapb.R.id.email;
//import static com.leeway.athirapb.R.id.progressBar;
import static com.leeway.athirapb.R.id.user;

/**
 * Created by user on 8/9/2017.
 */

public class Sign_in extends AppCompatActivity implements OnHttpResponceForLogin {
//    TextView signup;
    EditText username,password;
    Button login;
    Boolean flag;
    TextView signup;
    SessionManager sessionManager;
    private FluentSnackbar mFluentSnackbar;
    //ProgressDialog progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        signup = (TextView) findViewById(R.id.signup);
        mFluentSnackbar = FluentSnackbar.create(this);
//        progressBar = new ProgressDialog(this,
//                ProgressDialog.STYLE_SPINNER);
//        progressBar.setIndeterminate(false);
//        progressBar.setMessage("Signing in...");
//        progressBar.setCancelable(false);
//
//        progressBar.cancel();

//        mobile= (EditText) findViewById(R.id.mob);
//        email= (EditText) findViewById(R.id.email);
        //signup=



        login = (Button) findViewById(R.id.login);
//        String use=getPreferences(user).toString();
//        if (use.isEmpty())
//        {
//           Intent intent=new Intent(Sign_in.this,MainActivity.class);
//            startActivity(intent);
//
//        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user = username.getText().toString();
                String pas = password.getText().toString();

                validate(user, pas);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this, Sign_up.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void validate(String user,String pas)
    {
        flag=true;
        if(user.isEmpty())
        {
            username.setFocusable(true);
            username.setError("error");
            Toast.makeText(Sign_in.this,"fail",Toast.LENGTH_LONG).show();
        }
//        else if
//        {
//
//        }
        else if(pas.isEmpty())
        {
            password.setFocusable(true);
            password.setError("error");
            Toast.makeText(Sign_in.this,"fail",Toast.LENGTH_LONG).show();
        }
        else if (user.equals("")&&pas.equals("")) {
            password.setFocusable(true);
            password.setError("error");
            Toast.makeText(Sign_in.this, "fail", Toast.LENGTH_LONG).show();
        }
        else{
            username.setError(null);
            password.setError(null);
//            Intent intent=new Intent(Sign_in.this,MainActivity.class);
//            startActivity(intent);
//            Toast.makeText(Sign_in.this,"login",Toast.LENGTH_SHORT).show();
           // progressBar.show();
            HttpRequestForLogin httpRequestForLogin=new HttpRequestForLogin(this);
            httpRequestForLogin.AttemtToLogin(user,pas);
        }


    }

    @Override
    public void OnLoginSuccess(String stautus, Boolean success) {
       // progressBar.cancel();
        mFluentSnackbar.create("Sign in failed")
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
        //progressBar.cancel();
        mFluentSnackbar.create("Sign in failed")
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
       // progressBar.cancel();
        if(b)
        {
            Log.e("username: ",username.getText().toString() );
            Log.e("password: ",password.getText().toString() );
            sessionManager=new SessionManager(this);
            sessionManager.SaveUseId(code.getUserId().toString());
            sessionManager.SaveCredentials(username.getText().toString(),password.getText().toString(),code.getEmail(),code.getPhone());
            sessionManager.SaveUseId(code.getUserId().toString());
            sessionManager.SaveRole(code.getRole_status());

            if(sessionManager.getUserId().equals(""))
            {

                Intent int1=new Intent(this,Sign_in.class);
                startActivity(int1);
                finish();
            }
            else
            {

                if(code.getRole_status().equals("1"))
                {   Intent int2=new Intent(this,Admin.class);
                    startActivity(int2);
                    finish();

                }else
                {
                    Intent int2=new Intent(this,MainActivity.class);
                    startActivity(int2);
                    finish();
                }

            }
           // sessionManager.SaveUseId(code.getUserId().toString());
//            sessionManager.SaveRole(code.get(0).getRole());


//            Intent intent=new Intent(this,MainActivity.class);
//            startActivity(intent);
//            finish();
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


