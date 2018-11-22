package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baren.almi.almibarenandroid.R;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class PagerPaginaProductoAdapter extends PagerAdapter {
    private List<String> imagenes;
    private Context context;
    private LayoutInflater inflater;

    public PagerPaginaProductoAdapter(List<String> imagenes, Context context) {
        this.imagenes = imagenes;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imagenes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View imageLayout = inflater.inflate(R.layout.sliding_images_layout, container, false);
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
        Glide.with(context).load(imagenes.get(position)).into(imageView);
        container.addView(imageLayout, 0);
        return imageLayout;
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }

}
