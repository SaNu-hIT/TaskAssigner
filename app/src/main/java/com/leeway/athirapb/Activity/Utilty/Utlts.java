package com.leeway.athirapb.Activity.Utilty;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.leeway.athirapb.R;

/**
 * Created by intellyelabs on 16/08/17.
 */

public class Utlts {

    private static Utlts mUtilities;

    private static Context mContext;

    public static Utlts getInstance(Context context) {

        mContext = context;
        if (mUtilities == null) {
            mUtilities = new Utlts();

        }
        return mUtilities;
    }

    public void changeHomeFragment(Fragment fragment, String tag,
                                   FragmentActivity act) {
        if (fragment != null) {
            FragmentManager fragmentManager = act.getSupportFragmentManager();
            fragmentManager.beginTransaction().addToBackStack(tag);
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment, tag)
                    .commit();
        } else {
            // error in creating fragment
            Log.e("Utilities", "Error in creating fragment");
        }
    } public void changeHomeFragmentAdmin(Fragment fragment, String tag,
                                   FragmentActivity act) {
        if (fragment != null) {
            FragmentManager fragmentManager = act.getSupportFragmentManager();
            fragmentManager.beginTransaction().addToBackStack(tag);
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_admin, fragment, tag)
                    .commit();
        } else {
            // error in creating fragment
            Log.e("Utilities", "Error in creating fragment");
        }
    }

}
