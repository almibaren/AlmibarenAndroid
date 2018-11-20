package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ConsolaSingleton {
    private static ConsolaSingleton consolaSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private ConsolaSingleton(Context context){
        ConsolaSingleton.context = context;
        requestQueue = getRequestQueue();
    }
    public static synchronized ConsolaSingleton getInstance(Context context){
        if (consolaSingleton == null){
            consolaSingleton = new ConsolaSingleton(context);
        }
        return consolaSingleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}
