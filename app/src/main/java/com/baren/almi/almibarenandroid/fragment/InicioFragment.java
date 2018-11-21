package com.baren.almi.almibarenandroid.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.adapter.ProductosInicioAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.PopularesRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private RecyclerView rvPopulares;
    private Context context;
    private ProductosInicioAdapter productosInicioAdapter;


    public InicioFragment() {
    }


    public static android.support.v4.app.Fragment newInstance() {
        InicioFragment inicioFragment = new InicioFragment();

        return inicioFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPopulares = view.findViewById(R.id.rvPopulares);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        rvPopulares.setLayoutManager(layoutManager);

        ProductosInicioAdapter prod=new ProductosInicioAdapter(this.context);
        List<Productos> items=new ArrayList<Productos>();
        PopularesRVAdapter popularesRVAdapter = new PopularesRVAdapter(this.context,items);
        prod.cargarPopulares(items,popularesRVAdapter);
        rvPopulares.setAdapter(popularesRVAdapter);



    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
