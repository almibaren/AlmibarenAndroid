package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ProductoEspecificoSingleton {
    private static ProductoEspecificoSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private ProductoEspecificoSingleton(Context context){
        ProductoEspecificoSingleton.context=context;
        requestQueue = getRequestQueue();
    }

    public static  synchronized ProductoEspecificoSingleton getInstance(Context context){
        if (singleton==null){
            singleton=new ProductoEspecificoSingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}
