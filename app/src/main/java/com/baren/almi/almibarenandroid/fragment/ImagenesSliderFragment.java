package com.baren.almi.almibarenandroid.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baren.almi.almibarenandroid.R;
import com.bumptech.glide.Glide;


public class ImagenesSliderFragment extends Fragment {

    private Context context;
    private String img;

    public ImagenesSliderFragment() {
        // Required empty public constructor
    }

    public void setData(Context context, String img) {
        this.context = context;
        this.img = img;
    }

    public static ImagenesSliderFragment newInstance() {
        ImagenesSliderFragment fragment = new ImagenesSliderFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_imagenes_slider, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView iv = view.findViewById(R.id.ivSlider);
        Glide.with(context).load(img).into(iv);
    }

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
