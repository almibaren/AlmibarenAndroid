package com.baren.almi.almibarenandroid.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.adapter.ListConsolaAdapter;

public class ConsolasFragment extends Fragment {
    private ListView lvConsola;
    private ListConsolaAdapter adapter;
    public ConsolasFragment() {
    }


    public static Fragment newInstance() {
        ConsolasFragment consolasFragment = new ConsolasFragment();

        return consolasFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_consolas, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvConsola=view.findViewById(R.id.lvConsolas);
        adapter = new ListConsolaAdapter(getContext());
        lvConsola.setAdapter(adapter);
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
