package com.leeway.athirapb.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Activity.DetaildActivity.DetailsActivity;
import com.leeway.athirapb.Activity.Activity.Sign_in;
import com.leeway.athirapb.Activity.Fragment.ApplyLeaveFragment;
import com.leeway.athirapb.Activity.Fragment.Calender.CalenderFragement;
import com.leeway.athirapb.Activity.Fragment.DashBoard.DashBoardFragment;
import com.leeway.athirapb.Activity.Fragment.DashBoardMain.DashFragments;
import com.leeway.athirapb.Activity.Fragment.Notification.NotificationFragment;
import com.leeway.athirapb.Activity.Fragment.ProjectFragment;
import com.leeway.athirapb.Activity.Fragment.Status.Employee_status;
import com.leeway.athirapb.Activity.Fragment.Status.LeaveFragmentFragment;
import com.leeway.athirapb.Activity.Fragment.Status.StatusFragment;
import com.leeway.athirapb.Activity.Fragment.StatusUpdationFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.CompletedFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.PendingFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.TicketsFragement;
import com.leeway.athirapb.Activity.Fragment.dummy.DummyContent;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceNull;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.Activity.Utilty.Utlts;
import com.leeway.athirapb.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,CalenderFragement.OnFragmentInteractionListener, TicketsFragement.OnFragmentInteractionListener,ProjectFragment.OnListFragmentInteractionListeners,DashBoardFragment.OnListFragmentInteractionListener,DashFragments.OnFragmentInteractionListenerss,PendingFragment.OnListFragmentInteractionListenerpendeing,CompletedFragment.OnListFragmentInteractionListenerCompleted,NotificationFragment.OnListFragmentInteractionListenerNotification,StatusFragment.OnFragmentInteractionListener,LeaveFragmentFragment.OnListFragmentInteractionListener,Employee_status.OnListFragmentInteractionListener,OnHttpResponceNull,ApplyLeaveFragment.OnFragmentInteractionListener,StatusUpdationFragment.OnFragmentInteractionListener {
    Fragment fragment;
    DrawerLayout drawer;

    LinearLayout dashboard,projects,tickets,calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dashboard= (LinearLayout) findViewById(R.id.dashboard);
        projects= (LinearLayout) findViewById(R.id.projects);
        tickets= (LinearLayout) findViewById(R.id.tickets);
        calender= (LinearLayout) findViewById(R.id.calender);
        fragment = new DashFragments();
        Utlts.getInstance(MainActivity.this).changeHomeFragment(
                fragment, "MapsActivity", MainActivity.this);
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new DashFragments();
                Utlts.getInstance(MainActivity.this).changeHomeFragment(
                        fragment, "MapsActivity", MainActivity.this);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ProjectFragment();
                Utlts.getInstance(MainActivity.this).changeHomeFragment(
                        fragment, "MapsActivity", MainActivity.this);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new TicketsFragement();
                Utlts.getInstance(MainActivity.this).changeHomeFragment(
                        fragment, "MapsActivity", MainActivity.this);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ApplyLeaveFragment();
                Utlts.getInstance(MainActivity.this).changeHomeFragment(
                        fragment, "MapsActivity", MainActivity.this);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new StatusUpdationFragment();
                Utlts.getInstance(MainActivity.this).changeHomeFragment(
                        fragment, "MapsActivity", MainActivity.this);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog diaBox = AskOption();
            diaBox.show();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            fragment = new NotificationFragment();
            Utlts.getInstance(MainActivity.this).changeHomeFragment(
                    fragment, "MapsActivity", MainActivity.this);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            return true;
        }  if (id == R.id.logout) {
            SessionManager sessionManager=new SessionManager(this);
            sessionManager.ClearAll();
            Intent intent=new Intent(this,Sign_in.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(int item) {
        Toast.makeText(this, ""+item, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, DetailsActivity.class);
        intent.putExtra("PROID",item);

        startActivity(intent);




    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.DashBoard.dummy.DummyContent.DummyItem item) {

    }




    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.TicketsFragment.dummy.DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.Notification.dummy.DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.Status.dummy.DummyContent.DummyItem item) {

    }

    @Override
    public void OnLoginNull(String stautus) {
        Intent intent=new Intent(this, Sign_in.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteractions(String uri) {

    }



    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }
}
