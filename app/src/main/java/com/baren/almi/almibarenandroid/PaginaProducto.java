package com.baren.almi.almibarenandroid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class PaginaProducto extends AppCompatActivity {

    private String idProducto = "3";
    private TextView tvNombreProd, tvPrecioProd, tvDtoProd, tvPrecioVProd, tvDescProd;
    private ListView lvOpinionesProd;
    private ViewPager vpImagenesProd;
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/product/";

    public PaginaProducto() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //idProducto = (String)savedInstanceState.get("productId");
        tvNombreProd = findViewById(R.id.tvNombreProd);
        tvPrecioProd = findViewById(R.id.tvPrecioProd);
        tvDtoProd = findViewById(R.id.tvDtoProd);
        tvPrecioVProd = findViewById(R.id.tvPrecioVProd);
        tvDescProd = findViewById(R.id.tvDescProd);
        lvOpinionesProd = findViewById(R.id.lvOpinionesProd);
        vpImagenesProd = findViewById(R.id.vpImagenesProd);
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
                    Log.d("IGOR",response.getString("nombre"));
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
