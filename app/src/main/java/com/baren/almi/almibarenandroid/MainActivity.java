package com.baren.almi.almibarenandroid;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.baren.almi.almibarenandroid.fragment.AcercaDeFragment;
import com.baren.almi.almibarenandroid.fragment.AjustesFragment;
import com.baren.almi.almibarenandroid.fragment.IniciarSesionFragment;
import com.baren.almi.almibarenandroid.fragment.InicioFragment;
import com.baren.almi.almibarenandroid.fragment.MainFragment;
import com.baren.almi.almibarenandroid.fragment.SoporteTecnicoFragment;
import com.baren.almi.almibarenandroid.fragment.UbicacionTiendaFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        MainFragment mainFragment =new MainFragment();
        mainFragment.setActivity(this);
        getSupportFragmentManager().beginTransaction().add(R.id.contentMain,mainFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d("igor", id + "==" + R.id.inicio);
        if (id == R.id.inicio) {
            MainFragment mainFragment =new MainFragment();
            mainFragment.setActivity(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain,mainFragment).commit();
        } else if (id == R.id.servicioTecnico) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new SoporteTecnicoFragment()).commit();
        } else  if (id == R.id.acercaDe){
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new AcercaDeFragment()).commit();
        } else if (id == R.id.ubicacion){
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new UbicacionTiendaFragment()).commit();
        }else if (id == R.id.ajustes){
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new AjustesFragment()).commit();
        }else if (id == R.id.sesion){
            String sesion= item.getTitle().toString();
            if (sesion.equals("Iniciar Sesión")){
                getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new IniciarSesionFragment()).commit();
            }else if(sesion=="Cerrar Sesion"){
                Session session = new Session(getApplicationContext());
                session.borrarSesion(getMenu(),getHeader(),getApplicationContext());
                MainFragment mainFragment =new MainFragment();
                mainFragment.setActivity(this);
                getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, mainFragment).commit();
            }

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Menu getMenu() {
        return navigationView.getMenu();
    }

    public View getHeader() {
        return navigationView.getHeaderView(0);
    }
//FUNCION PARA CERRAR EL KEYBOARD AL TOCAR FUERA DE EL
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

}
