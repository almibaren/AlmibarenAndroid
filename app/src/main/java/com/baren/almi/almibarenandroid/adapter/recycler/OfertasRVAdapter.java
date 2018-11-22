package com.baren.almi.almibarenandroid.adapter.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baren.almi.almibarenandroid.PaginaProductoActivity;
import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class OfertasRVAdapter extends RecyclerView.Adapter<OfertasRVAdapter.MyViewHolder> {
    private Context context;
    private List<Productos> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;

        public MyViewHolder(CardView c) {
            super(c);
            mCardView = c;
        }
    }
    public OfertasRVAdapter(Context context, List<Productos> ofertas) {
        this.context = context;
        this.list=ofertas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_inicio, viewGroup, false);
        OfertasRVAdapter.MyViewHolder myViewHolder = new MyViewHolder(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaginaProductoActivity paginaProducto = new PaginaProductoActivity();
                Intent intent = new Intent(context,PaginaProductoActivity.class);
                intent.putExtra("productId",((TextView)v.findViewById(R.id.tvIdProducto)).getText().toString());
                context.startActivity(intent);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ((TextView) myViewHolder.mCardView.findViewById(R.id.tvProducto)).setText(list.get(i).getNombre());
        ((TextView)myViewHolder.mCardView.findViewById(R.id.tvPrecioProducto)).setText(list.get(i).getCalculado());
        Glide.with(context).load(list.get(i).getUrl()).into((ImageView) myViewHolder.mCardView.findViewById(R.id.ivProducto));


    }

    @Override
    public int getItemCount() {
        return list.size() ;

    }
    }
