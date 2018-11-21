package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.adapter.recycler.PopularesRVAdapter;
import com.baren.almi.almibarenandroid.singleton.CardViewSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosInicioAdapter {
    private Context context;
    private RequestQueue requestQueue;
    private JsonRequest jsArrayRequest;
    private String URL_BASE = "http://192.168.6.161/almibarenBackend/products/";


    public List<Productos> getListPopulares() {
        Log.d("JON","ESTOY COGIENDO LA LISTA");
        return list.get(0);
    }

    public List<Productos> getListRecomendados() {
        return list.get(1);
    }

    public List<Productos> getListValorados() {
        return list.get(2);
    }

    public List<Productos> getListOfertas() {
        return list.get(3);
    }

    public boolean isListNull() {
        return (list==null);
    }

    private List<List<Productos>> list;

    public ProductosInicioAdapter(Context context,final PopularesRVAdapter adapter) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                list = parseJson(response);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    private List<List<Productos>> parseJson(JSONObject jsonObject) {
        List<List<Productos>> list = new ArrayList<List<Productos>>();
        List<Productos> listPopulares = new ArrayList<>();
        List<Productos> listRecomendados = new ArrayList<>();
        List<Productos> listValorados = new ArrayList<>();
        List<Productos> listOfertas = new ArrayList<>();
        try {
            JSONArray jsonArrayPopulares = jsonObject.getJSONArray("populares");
            JSONArray jsonArrayRecomendados = jsonObject.getJSONArray("recomendados");
            JSONArray jsonArrayValorados = jsonObject.getJSONArray("valorados");
            JSONArray jsonArrayOfertas = jsonObject.getJSONArray("ofertas");


            for (int i = 0; i < jsonArrayPopulares.length(); i++) {

                JSONObject jsonObject1 = jsonArrayPopulares.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                listPopulares.add(producto);

            }

            for (int i = 0; i < jsonArrayRecomendados.length(); i++) {

                JSONObject jsonObject1 = jsonArrayRecomendados.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                listRecomendados.add(producto);


            }
            for (int i = 0; i < jsonArrayValorados.length(); i++) {
                JSONObject jsonObject1 = jsonArrayValorados.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                listValorados.add(producto);


            }
            for (int i = 0; i < jsonArrayOfertas.length(); i++) {

                JSONObject jsonObject1 = jsonArrayOfertas.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                listOfertas.add(producto);


            }
            list.add(listPopulares);
            list.add(listRecomendados);
            list.add(listValorados);
            list.add(listOfertas);



        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;

    }

}
