package com.baren.almi.almibarenandroid;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PaginaProductoActivity extends Activity {

    private String idProducto = "3";
    private TextView tvNombreProd, tvPrecioProd, tvDtoProd, tvPrecioVProd, tvDescProd;
    private ListView lvOpinionesProd;
    private ViewPager vpImagenesProd;
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/product/";
    List<String> imagenes;
    List<Opinion> opiniones;

    public PaginaProductoActivity() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_producto2);

        //idProducto = (String)savedInstanceState.get("productId");
        tvNombreProd = findViewById(R.id.tvNombreProd);
        tvPrecioProd = findViewById(R.id.tvPrecioProd);
        tvDtoProd = findViewById(R.id.tvDtoProd);
        tvPrecioVProd = findViewById(R.id.tvPrecioVProd);
        tvDescProd = findViewById(R.id.tvDescProd);
        lvOpinionesProd = findViewById(R.id.lvOpinionesProd);
        vpImagenesProd = findViewById(R.id.vpImagenesProd);
        imagenes = new ArrayList<>();
        try {
            getProductInfo();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getProductInfo() throws JSONException {
        JsonObjectRequest request;
        String url = URL_BASE + "?productId=" + idProducto;

        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    tvNombreProd.setText(response.getString("nombre"));
                    tvPrecioProd.setText(response.getString("precio"));
                    tvDtoProd.setText(response.getString("descuento"));
                    tvPrecioVProd.setText(response.getString("precio"));
                    tvDescProd.setText(response.getString("descripcion"));
                    imagenes.add(response.getString("url"));
                    imagenes.add(response.getString("url2"));
                    imagenes.add(response.getString("url3"));
                    imagenes.add(response.getString("url4"));
                    JSONArray opinions = response.getJSONArray("opiniones");
                    for (int i = 0; i < opinions.length(); i++) {
                        Opinion o = new Opinion(opinions.getJSONObject(i).getString("user"), opinions.getJSONObject(i).getString("valoracion"), opinions.getJSONObject(i).getString("comentario"));
                        opiniones.add(o);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        UsuarioSingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}
