package com.leeway.athirapb.Activity.Activity;



//import android.support.v4.app.FragmentManager;
//
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Fragment.Status.StatusFragment;
import com.leeway.athirapb.Activity.OnFragmentActionClick;
import com.leeway.athirapb.R;

/**
 * Created by user on 8/21/2017.
 */

public class Status extends AppCompatActivity implements OnFragmentActionClick {
    FloatingActionButton floatingActionButton;
    FrameLayout frameLayout;
    LinearLayout linearLayout;

    @Override
    public void onClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(view.VISIBLE);
                linearLayout.setVisibility(view.GONE);
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                StatusFragment fragment = new StatusFragment();
//                fragmentTransaction.replace(R.id.container,fragment);
//                fragmentTransaction.commit();
                Toast.makeText(new Status(), "ygftuygu", Toast.LENGTH_SHORT).show();
               // getFragmentManager().beginTransaction().add(R.id.container,new StatusFragment()).commit();
            }
        });
    }
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_dash_fragments);
       floatingActionButton=(FloatingActionButton)findViewById(R.id.floating);
       frameLayout=(FrameLayout)findViewById(R.id.container);
       linearLayout=(LinearLayout)findViewById(R.id.layout);
   }
}
