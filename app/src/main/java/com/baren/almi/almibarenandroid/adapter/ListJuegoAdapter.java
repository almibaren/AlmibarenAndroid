package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.singleton.JuegoSingleton;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListJuegoAdapter extends ArrayAdapter {

    public ImageView ivProd=null;
    public TextView tvProd,tvProdPrec, tvProdDesc, tvIdProd, tvPrecProSid;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsArrayRequest;
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/games";
    private List<Productos> items;

    public ListJuegoAdapter(Context context) {
        super(context, 0);
        requestQueue = Volley.newRequestQueue(context);
        jsArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_BASE, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                items = parseJson(response);
                notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("asier", error.getMessage());
            }
        });
        JuegoSingleton.getInstance(getContext()).addToRequestQueue(jsArrayRequest);
    }

    private List<Productos> parseJson(JSONArray jsonArray) {
    List<Productos> productos = new ArrayList<Productos>();

    for (int i = 0;i<jsonArray.length();i++){
        try {

            JSONObject objectJuego= jsonArray.getJSONObject(i);
            Productos prod = new Productos(objectJuego.getString("id"), objectJuego.getString("nombre"), objectJuego.getString("precio"),objectJuego.getString("url"), objectJuego.getString("descuento"));
            productos.add(prod);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    return productos;
    }
public int getCount(){
        return items != null ? items.size() : 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());

        View listJuegoView = convertView;

        listJuegoView = layoutInflater.inflate(R.layout.cardview_example,parent,false);
        ivProd=listJuegoView.findViewById(R.id.ivProducto);
        tvProd=listJuegoView.findViewById(R.id.tvProducto);
        tvIdProd=listJuegoView.findViewById(R.id.tvIdProducto);
        tvProdPrec=listJuegoView.findViewById(R.id.tvPrecioProducto);
        tvPrecProSid=listJuegoView.findViewById(R.id.tvPrecioProductoSinDescuento);
        tvProdDesc=listJuegoView.findViewById(R.id.tvDtoProducto);
        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_juegos);
        try {
            Glide.with(getContext()).setDefaultRequestOptions(requestOptions).load(items.get(position).getUrl()).into(ivProd);
        }catch(IllegalArgumentException ex) {
            Log.d("jon", String.valueOf(ivProd.getTag()));
        }
        tvIdProd.setText(items.get(position).getId());
        tvProd.setText(items.get(position).getNombre());
        tvProdPrec.setText(items.get(position).getCalculado());
        tvPrecProSid.setText(items.get(position).getPrecio());
        tvProdDesc.setText(items.get(position).getDescuento());
        return listJuegoView;
    }
}
