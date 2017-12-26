package com.leeway.athirapb.Activity.Activity.DetaildActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForProject;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceProject;
import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.util.List;


public class DetailsActivity extends Activity implements OnHttpResponceProject {

    private RecyclerView recyclerView;
   TextView name,phone,altmobile,projectdescription,advance,amount;
    private TextView tax,total,balance,total_amount;


ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);



        name= (TextView) findViewById(R.id.cust_name);
        phone= (TextView) findViewById(R.id.mobile);
        altmobile= (TextView) findViewById(R.id.altmobile);
        projectdescription= (TextView) findViewById(R.id.projectdescription);
        amount= (TextView) findViewById(R.id.amount);
        tax= (TextView) findViewById(R.id.tax);
        total= (TextView) findViewById(R.id.total);
        advance= (TextView) findViewById(R.id.advance);
        balance= findViewById(R.id.balance);
        total_amount= (TextView) findViewById(R.id.total_amount);
        imageView=findViewById(R.id.imagevview);

        SessionManager sessionManager=new SessionManager(this);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String usrid=sessionManager.getUserId();

        if(b!=null)
        {
            String j = b.get("PROID").toString();
            HttpRequestForProject httpRequestForProject=new HttpRequestForProject(this);
            httpRequestForProject.getProject(usrid,j);
        }
//        String newString;
//        if (savedInstanceState == null) {
//            Intent extras = extras.getIntent().getExtras();
//            if(extras == null) {
//                newString= null;
//            } else {
//                newString= extras.getString("PROID");
//            }
//        } else {
//            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
//        }

//        Log.e( "onCreate: ",""+newString );

//        name.setText("NAME : "+bean.getCName());
//        phone.setText("PHONE : "+bean.getMobile());
//        altmobile.setText("TIN NO : "+bean.getAltmobile());
//        emailid.setText("EMAIL : "+bean.getEmailId());
//        amount.setText(bean.getAmount().toString());
//        tax.setText(bean.getTax().toString()+"/-");
//        total.setText(bean.getTotal().toString());
//        advance.setText(bean.getAdvance().toString()+"/-");
//        balance.setText(bean.getBalance().toString()+"/-");
//        total_amount.setText(bean.getTotal().toString()+"/-");








    }

    public void onBackPressed(View view) {
        onBackPressed();
    }

    @Override
    public void OnProjectFaild(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnProjectSuccessTrue(String success, boolean b, List<ProjectInfo> projectInfoList) {

        String ProName=projectInfoList.get(0).getProName();
        String ClientName=projectInfoList.get(0).getClientName();
        String ProDesc=projectInfoList.get(0).getProDesc();
        String AssignDate=projectInfoList.get(0).getAssignDate();
        String ClientPhnumber=projectInfoList.get(0).getClientPhnumber();
        String EstimatedCost=projectInfoList.get(0).getEstimatedCost();
        String SubmissionDate=projectInfoList.get(0).getSubmissionDate();
        String TeamStrength=projectInfoList.get(0).getTeamStrength();
        String NewsImageurl=projectInfoList.get(0).getProjectImage().get(0).getNewsImageurl();

        UpdateUi(ProName,ClientName,ProDesc,AssignDate,ClientPhnumber,EstimatedCost,SubmissionDate,TeamStrength,NewsImageurl);





    }

    private void UpdateUi(String proName, String clientName, String proDesc, String assignDate, String clientPhnumber, String estimatedCost, String submissionDate, String teamStrength, String newsImageurl) {



        name.setText("Project Name :"+proName);
        phone.setText("Client Name :"+clientName);
        altmobile.setText("No : "+clientPhnumber);
        projectdescription.setText("Description :"+proDesc);


        amount.setText("From :"+assignDate);
        tax.setText("End Date :"+submissionDate);
        total.setText("Cost :"+estimatedCost);
        advance.setText("Team Strength :"+teamStrength);
        balance.setText("");
        balance.setVisibility(View.GONE);
        total_amount.setVisibility(View.GONE);
        tax.setVisibility(View.VISIBLE);
        total_amount.setText("");


        Glide.with(this)
                .load(newsImageurl)
                .asBitmap()
                .placeholder(R.drawable.user)
                .into(imageView);

    }
}
