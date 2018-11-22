package com.baren.almi.almibarenandroid.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.Transacciones;
import java.util.List;

public class CompraAjusteRVAdapter extends RecyclerView.Adapter<CompraAjusteRVAdapter.MyViewHolder> {
    private Context context;
    private List<Transacciones> list;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvIdTrans;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdTrans=itemView.findViewById(R.id.tvTranCompra);
        }
    }

    public CompraAjusteRVAdapter(Context context, List<Transacciones> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView   = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_transacciones, viewGroup, false);
        CompraAjusteRVAdapter.MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        (myViewHolder.tvIdTrans).setText(list.get(i).getProductos().getNombre());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
