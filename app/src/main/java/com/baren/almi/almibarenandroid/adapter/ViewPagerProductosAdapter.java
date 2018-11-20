package com.baren.almi.almibarenandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baren.almi.almibarenandroid.fragment.ConsolasFragment;
import com.baren.almi.almibarenandroid.fragment.InicioFragment;
import com.baren.almi.almibarenandroid.fragment.JuegosFragment;
import com.baren.almi.almibarenandroid.fragment.SmartphoneTabletFragment;

public class ViewPagerProductosAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerProductosAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                InicioFragment inicioFragment = new InicioFragment();
                return inicioFragment;
            case 1:
                JuegosFragment juegosFragment = new JuegosFragment();
                return juegosFragment;
            case 2:
                ConsolasFragment consolasFragment = new ConsolasFragment();
                return consolasFragment;
            case 3:
                SmartphoneTabletFragment smartphoneTabletFragment = new SmartphoneTabletFragment();
                return smartphoneTabletFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
