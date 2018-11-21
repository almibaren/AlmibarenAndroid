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
import com.baren.almi.almibarenandroid.adapter.recycler.OfertasRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.PopularesRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.RecomendadosRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.ValoradosRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private RecyclerView rvPopulares, rvRecomendadosParaTi, rvMejorValorados, rvOfertas;
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
        //POPULARES COMO EL PARTIDO
        rvPopulares = view.findViewById(R.id.rvPopulares);
        rvRecomendadosParaTi = view.findViewById(R.id.rvRecomendadosParaTi);
        rvMejorValorados = view.findViewById(R.id.rvMejorValorados);
        rvOfertas = view.findViewById(R.id.rvOfertas);
        LinearLayoutManager pops = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager recs = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager vals = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager ofes = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);

        rvPopulares.setLayoutManager(pops);
        rvRecomendadosParaTi.setLayoutManager(recs);
        rvMejorValorados.setLayoutManager(vals);
        rvOfertas.setLayoutManager(ofes);

        ProductosInicioAdapter prod=new ProductosInicioAdapter(this.context);
        List<Productos> productos=new ArrayList<Productos>();
        List<Productos> recomendados=new ArrayList<Productos>();
        List<Productos> valorados=new ArrayList<Productos>();
        List<Productos> ofertas=new ArrayList<Productos>();
        PopularesRVAdapter popularesRVAdapter = new PopularesRVAdapter(this.context,productos);
        RecomendadosRVAdapter recomendadosRVAdapter = new RecomendadosRVAdapter(this.context,recomendados);
        ValoradosRVAdapter valoradosRVAdapter = new ValoradosRVAdapter(this.context,valorados);
        OfertasRVAdapter ofertasRVAdapter = new OfertasRVAdapter(this.context,ofertas);

        prod.cargarPopulares(productos,popularesRVAdapter);
        rvPopulares.setAdapter(popularesRVAdapter);

        prod.cargarRecomendados(recomendados,recomendadosRVAdapter);
        rvRecomendadosParaTi.setAdapter(recomendadosRVAdapter);

        prod.cargarValorados(valorados,valoradosRVAdapter);
        rvMejorValorados.setAdapter(valoradosRVAdapter);

        prod.cargarOfertas(ofertas,ofertasRVAdapter);
        rvOfertas.setAdapter(ofertasRVAdapter);



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
