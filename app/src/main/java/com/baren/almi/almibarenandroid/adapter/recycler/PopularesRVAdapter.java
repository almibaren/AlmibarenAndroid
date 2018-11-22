package com.baren.almi.almibarenandroid.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.adapter.ProductosInicioAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

public class PopularesRVAdapter extends RecyclerView.Adapter<PopularesRVAdapter.MyViewHolder> {
    private Context context;
    private List<Productos> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
            public CardView mCardView;

        public MyViewHolder(CardView c) {
            super(c);
            mCardView = c;
        }
    }

    public PopularesRVAdapter(Context context,List<Productos> pop) {
        this.context = context;
        this.list=pop;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_inicio, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(cardView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ((TextView) myViewHolder.mCardView.findViewById(R.id.tvProducto)).setText(list.get(i).getNombre());
        //((TextView)myViewHolder.mCardView.findViewById(R.id.tvPrecioProducto)).setText();
        Glide.with(context).load(list.get(i).getUrl()).into((ImageView) myViewHolder.mCardView.findViewById(R.id.ivProducto));
        /*((TextView) myViewHolder.mCardView.findViewById(R.id.tvPrecioProducto)).setText(list.get(i).getPrecio());
        ((TextView) myViewHolder.mCardView.findViewById(R.id.tvDtoProducto)).setText(list.get(i).getDescuento());*/

    }

    @Override
    public int getItemCount() {
            return list.size() ;

    }


}
