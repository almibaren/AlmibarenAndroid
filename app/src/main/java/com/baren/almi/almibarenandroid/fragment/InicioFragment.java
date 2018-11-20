package com.baren.almi.almibarenandroid.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.adapter.recycler.PopularesRVAdapter;

public class InicioFragment extends Fragment {

    private RecyclerView rvPopulares;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

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
        rvPopulares.setLayoutManager(new LinearLayoutManager(context));
         PopularesRVAdapter popularesRVAdapter = new PopularesRVAdapter(context);
        rvPopulares.setAdapter(popularesRVAdapter);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
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
