package com.baren.almi.almibarenandroid;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class FragmentManagerHandler {

    private static FragmentManager fm;
    private static FragmentManagerHandler fragmentManagerHandler;

    private FragmentManagerHandler() {

    }

    public static synchronized FragmentManagerHandler getInstance() {
        if (fragmentManagerHandler == null) {
            fragmentManagerHandler = new FragmentManagerHandler();
        }
        return fragmentManagerHandler;
    }

    public void setFragmentManager(FragmentManager fm) {
        this.fm = fm;
    }

    public static FragmentManager getFragmentManager() {
        return fm;
    }
}
