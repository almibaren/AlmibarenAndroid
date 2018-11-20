package com.baren.almi.almibarenandroid.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baren.almi.almibarenandroid.MainActivity;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.adapter.ViewPagerProductosAdapter;

public class MainFragment extends Fragment {
    private MainActivity activity;
    private TabLayout tabsProductos;

    public MainFragment() {
    }

    public static Fragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("IGOR","ONCREATE");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //Log.d("IGOR","ONCREATEVIEW");

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabsProductos);
        tabLayout.addTab(tabLayout.newTab().setText("Inicio"));
        tabLayout.addTab(tabLayout.newTab().setText("Juegos"));
        tabLayout.addTab(tabLayout.newTab().setText("Consolas"));
        tabLayout.addTab(tabLayout.newTab().setText("Moviles"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//Log.d("IGOR","ONVIEWCREATED");
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerProductos);
        final ViewPagerProductosAdapter viewPagerProductosAdapter = new ViewPagerProductosAdapter
                (activity.getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(viewPagerProductosAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // Log.d("IGOR","ONVIEWRESTORED");
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
