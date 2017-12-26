package com.leeway.athirapb.Activity.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.leeway.athirapb.Activity.Fragment.AddNotification;
import com.leeway.athirapb.Activity.Fragment.AddProjetcsFragment;
import com.leeway.athirapb.Activity.Fragment.AddTicketsFragment;
import com.leeway.athirapb.Activity.Fragment.DashAdmin;
import com.leeway.athirapb.Activity.Fragment.DashBoardMain.DashFragments;
import com.leeway.athirapb.Activity.Fragment.LeaveListing.LeaveListingFragment;
import com.leeway.athirapb.Activity.Fragment.ProjectFragment;
import com.leeway.athirapb.Activity.Fragment.StatusListing.StatusListingFragment;
import com.leeway.athirapb.Activity.Fragment.StatusUpdationFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.CompletedFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.PendingFragment;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.TicketsFragement;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.dummy.DummyContent;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceNull;
import com.leeway.athirapb.Activity.MainActivity;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.Activity.Utilty.Utlts;
import com.leeway.athirapb.R;

public class Admin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,DashAdmin.OnFragmentInteractionListener,AddNotification.OnFragmentInteractionListener,AddProjetcsFragment.OnFragmentInteractionListener,AddTicketsFragment.OnFragmentInteractionListener ,TicketsFragement.OnFragmentInteractionListener,ProjectFragment.OnListFragmentInteractionListeners,PendingFragment.OnListFragmentInteractionListenerpendeing,CompletedFragment.OnListFragmentInteractionListenerCompleted,OnHttpResponceNull,LeaveListingFragment.OnListFragmentInteractionListener,DashFragments.OnFragmentInteractionListenerss,StatusListingFragment.OnListFragmentInteractionListener
{

    private Fragment fragment;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sessionManager=new SessionManager(this);
        fragment = new DashFragments();
        Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                fragment, "DashFragment", Admin.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.admin, menu);
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

         Fragment   fragment = new AddNotification();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


                Fragment    fragment = new AddProjetcsFragment();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);
        }
        else if (id == R.id.nav_home) {


            Fragment    fragment = new DashFragments();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);
        }



        else if (id == R.id.nav_slideshow) {


            Fragment    fragment = new AddTicketsFragment();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);

        } else if (id == R.id.nav_manage) {
            Fragment    fragment = new TicketsFragement();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);

        } else if (id == R.id.nav_share) {
            Fragment    fragment = new ProjectFragment();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);


        } else if (id == R.id.nav_send) {

            sessionManager.ClearAll();
            Intent intent=new Intent(getBaseContext(),Sign_in.class);
            startActivity(intent);
finish();
        } else if (id == R.id.nav_list_leave) {

            Fragment    fragment = new LeaveListingFragment();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);


        }else if (id == R.id.status_list) {

            Fragment    fragment = new StatusListingFragment();
            Utlts.getInstance(Admin.this).changeHomeFragmentAdmin(
                    fragment, "DashFragment", Admin.this);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onFragmentInteractionAddTickets(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(int item) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void OnLoginNull(String stautus) {

    }

    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.LeaveListing.dummy.DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteractions(String uri) {

    }

    @Override
    public void onListFragmentInteraction(com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.DummyContent.DummyItem item) {

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
