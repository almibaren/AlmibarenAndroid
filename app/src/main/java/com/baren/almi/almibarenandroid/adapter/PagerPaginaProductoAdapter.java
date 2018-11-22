package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;

import com.baren.almi.almibarenandroid.fragment.ImagenesSliderFragment;

import java.util.List;

public class PagerPaginaProductoAdapter extends FragmentStatePagerAdapter {
    private List<String> imagenes;
    private Context context;
    private LayoutInflater inflater;


    public PagerPaginaProductoAdapter(FragmentManager fm, List<String> imagenes, Context context) {
        super(fm);
        this.imagenes = imagenes;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public Fragment getItem(int i) {
        ImagenesSliderFragment imagenesSliderFragment = new ImagenesSliderFragment();
        imagenesSliderFragment.setData(context, imagenes.get(i));
        return imagenesSliderFragment;
    }

    @Override
    public int getCount() {
        return imagenes.size();
    }

}
