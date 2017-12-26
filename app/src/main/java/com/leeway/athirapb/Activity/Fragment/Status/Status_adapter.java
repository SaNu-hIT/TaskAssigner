package com.leeway.athirapb.Activity.Fragment.Status;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by user on 8/23/2017.
 */

public class Status_adapter extends FragmentStatePagerAdapter {
    int tabCount;

//

    public Status_adapter(android.support.v4.app.FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                LeaveFragmentFragment leave=new LeaveFragmentFragment();
                return leave;
            case 1:
                Employee_status employee=new Employee_status();
                return employee;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
