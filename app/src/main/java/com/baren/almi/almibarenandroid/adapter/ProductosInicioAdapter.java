package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.baren.almi.almibarenandroid.adapter.recycler.OfertasRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.PopularesRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.RecomendadosRVAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.ValoradosRVAdapter;
import com.baren.almi.almibarenandroid.singleton.CardViewSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosInicioAdapter {
    private Context context;
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/";

    public void cargarPopulares(final List<Productos> pop,final PopularesRVAdapter ada) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "populares", pop, ada);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void cargarRecomendados (final List<Productos> recom, final RecomendadosRVAdapter rec) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "recomendados", recom, rec);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void cargarValorados (final List<Productos> valor, final ValoradosRVAdapter val) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "valorados", valor, val);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void cargarOfertas (final List<Productos> ofertas, final OfertasRVAdapter ofe) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "ofertas", ofertas, ofe);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        CardViewSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


    public ProductosInicioAdapter(Context context) {
            this.context=context;
    }

    private void parseJson(JSONObject jsonObject,String lista,List<Productos> pop,PopularesRVAdapter ada) {
        try {
            JSONArray jsonArrayPopulares = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayPopulares.length(); i++) {

                JSONObject jsonObject1 = jsonArrayPopulares.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                pop.add(producto);
                ada.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
     }
    private void parseJson(JSONObject jsonObject,String lista,List<Productos> recom,RecomendadosRVAdapter rec) {
        try {
            JSONArray jsonArrayRecomendados = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayRecomendados.length(); i++) {

                JSONObject jsonObject1 = jsonArrayRecomendados.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                recom.add(producto);
                rec.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJson(JSONObject jsonObject,String lista,List<Productos> valor,ValoradosRVAdapter val) {
        try {
            JSONArray jsonArrayValor = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayValor.length(); i++) {

                JSONObject jsonObject1 = jsonArrayValor.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                valor.add(producto);
                val.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJson(JSONObject jsonObject,String lista,List<Productos> ofertas,OfertasRVAdapter ofe) {
        try {
            JSONArray jsonArrayOfertas = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayOfertas.length(); i++) {

                JSONObject jsonObject1 = jsonArrayOfertas.getJSONObject(i);
                Productos producto = new Productos(jsonObject1.getString("url"), jsonObject1.getString("id"), jsonObject1.getString("nombre"), jsonObject1.getString("precio"), jsonObject1.getString("descuento"));
                ofertas.add(producto);
                ofe.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
