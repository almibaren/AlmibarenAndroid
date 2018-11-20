package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class UsuarioSingleton {

    private static UsuarioSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private UsuarioSingleton(Context context){
        UsuarioSingleton.context=context;
        requestQueue= getRequestQueue();
    }

    public static synchronized UsuarioSingleton getInstance(Context context){
        if (singleton==null){
            singleton = new UsuarioSingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}
