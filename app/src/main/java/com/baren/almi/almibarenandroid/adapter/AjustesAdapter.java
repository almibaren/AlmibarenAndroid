package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.Transacciones;
import com.baren.almi.almibarenandroid.adapter.recycler.CompraAjusteRVAdapter;

import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AjustesAdapter {
    private static final String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/users/profile";
    private Context context;

    public void cargarCompras(final List<Transacciones> comp, final CompraAjusteRVAdapter compaj) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJson(response, "comprajuste", comp, compaj);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        UsuarioSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public AjustesAdapter(Context context){
        this.context=context;
    }

    private void parseJson(JSONObject jsonObject, String lista, List<Transacciones> comp, CompraAjusteRVAdapter compaj) {
        try {
            JSONArray jsonArrayCompra = jsonObject.getJSONArray(lista);

            for (int i = 0; i < jsonArrayCompra.length(); i++) {

                JSONObject jsonObject1 = jsonArrayCompra.getJSONObject(i);
                Transacciones transaccion = new Transacciones(jsonObject1.getString("idTransaccion"), jsonObject1.getString("precio"),
                        jsonObject1.getString("fecha"),new Productos("",jsonObject1.getString("nombre"),"",jsonObject1.getString("url"),""));
                comp.add(transaccion);
                compaj.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
