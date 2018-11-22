package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baren.almi.almibarenandroid.Opinion;
import com.baren.almi.almibarenandroid.R;

import java.util.List;

public class OpinionesPaginaProductoAdapter extends BaseAdapter {

    private List<Opinion> opiniones;
    private Context context;

    public OpinionesPaginaProductoAdapter(List<Opinion> opiniones, Context context) {
        this.opiniones = opiniones;
        this.context = context;
    }

    @Override
    public int getCount() {
        return opiniones.size();
    }

    @Override
    public Object getItem(int position) {
        return opiniones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Opinion currentOpinion = opiniones.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.listview_opiniones_producto_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.tvProdOpUser)).setText(currentOpinion.getUser());
        ((TextView) convertView.findViewById(R.id.tvProdOpComment)).setText(currentOpinion.getComentario());
        ((TextView) convertView.findViewById(R.id.tvProdOpVal)).setText(currentOpinion.getValoracion());

        return convertView;
    }
}
