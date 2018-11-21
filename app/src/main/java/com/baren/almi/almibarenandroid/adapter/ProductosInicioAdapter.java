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
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/";



    public void cargarPopulares(final List<Productos> lis,final PopularesRVAdapter ada) {
        Log.d("JON","ESTOY COGIENDO LA LISTA");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "populares",lis,ada);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

    }

    public List<Productos> getListRecomendados() {
        return null;
    }

    public List<Productos> getListValorados() {
        return null;
    }

    public List<Productos> getListOfertas() {
        return null;
    }





    public ProductosInicioAdapter(Context context) {
            this.context=context;
    }

    private void parseJson(JSONObject jsonObject,String lista,List<Productos> lis,PopularesRVAdapter ada) {


        try {
            JSONArray jsonArrayPopulares = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayPopulares.length(); i++) {

                JSONObject jsonObject1 = jsonArrayPopulares.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                lis.add(producto);
                ada.notifyDataSetChanged();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


     }

}
