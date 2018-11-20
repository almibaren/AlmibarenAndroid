package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class JuegoSingleton {
    private static JuegoSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private JuegoSingleton(Context context){
        JuegoSingleton.context=context;
        requestQueue = getRequestQueue();
    }

    public static  synchronized JuegoSingleton getInstance(Context context){
        if (singleton==null){
            singleton=new JuegoSingleton(context);
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
