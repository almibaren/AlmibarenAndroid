package com.baren.almi.almibarenandroid.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.baren.almi.almibarenandroid.R;

public class PopularesRVAdapter extends RecyclerView.Adapter<PopularesRVAdapter.MyViewHolder>{
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;

        public MyViewHolder(CardView c) {
            super(c);
            mCardView = c;
        }
    }

    public PopularesRVAdapter(Context context){this.context = context;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView c = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_example,viewGroup,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
