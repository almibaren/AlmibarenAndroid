package com.baren.almi.almibarenandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.baren.almi.almibarenandroid.PaginaProductoActivity;
import com.baren.almi.almibarenandroid.Productos;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.singleton.SmartTabSingleton;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListSmarTabAdapter extends ArrayAdapter {
    public ImageView ivProd=null;
    public TextView tvProd, tvProdPrec, tvProdDesc, tvIdProd, tvProdPrecSid;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsArrayRequest;
    private String URL_BASE = "https://almibar.webcindario.com/almibarenBackend/products/smarttab";
    private List<Productos> list;
    public ListSmarTabAdapter(Context context){
        super(context, 0);
        requestQueue = Volley.newRequestQueue(context);
        jsArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_BASE, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        list = parseJson(response);
                        notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("jon", "Error en la respuesta" + error.getMessage());
            }
        });
        SmartTabSingleton.getInstance(getContext()).addToRequestQueue(jsArrayRequest);
    }
    private List<Productos> parseJson(JSONArray jsonArray){
        List<Productos> list = new ArrayList<Productos>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {

                JSONObject objProducto = jsonArray.getJSONObject(i);
                Log.d("jon", objProducto.toString());
                Productos prod = new Productos(objProducto.getString("id"), objProducto.getString("nombre"), objProducto.getString("precio"),objProducto.getString("url"), objProducto.getString("descuento"));

                list.add(prod);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int getCount(){
        return list != null ? list.size() : 0;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());

        View listSmartTabV = convertView;
        listSmartTabV = layoutInflater.inflate(R.layout.cardview_example, parent, false);
        ivProd=listSmartTabV.findViewById(R.id.ivProducto);
        tvProd=listSmartTabV.findViewById(R.id.tvProducto);
        tvIdProd=listSmartTabV.findViewById(R.id.tvIdProducto);
        tvProdPrec=listSmartTabV.findViewById(R.id.tvPrecioProducto);
        tvProdPrecSid=listSmartTabV.findViewById(R.id.tvPrecioProductoSinDescuento);
        tvProdPrec=listSmartTabV.findViewById(R.id.tvDtoProducto);
        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_smarttab);
        try {
            Glide.with(getContext()).setDefaultRequestOptions(requestOptions).load(list.get(position).getUrl()).into(ivProd);
        }catch(IllegalArgumentException ex) {
            Log.d("jon", String.valueOf(ivProd.getTag()));
        }
        tvIdProd.setText(list.get(position).getId());
        tvProd.setText(list.get(position).getNombre());
        tvProdPrec.setText(list.get(position).getPrecio());
        tvProdPrecSid.setText(list.get(position).getCalculado());
        //tvProdDesc.setText(list.get(position).getDescuento());
        listSmartTabV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaginaProductoActivity paginaProducto = new PaginaProductoActivity();
                Intent intent = new Intent(getContext(),PaginaProductoActivity.class);
                intent.putExtra("productId",((TextView)v.findViewById(R.id.tvIdProducto)).getText().toString());
                getContext().startActivity(intent);
            }
        });
        return listSmartTabV;
    }
}
