package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SmartTabSingleton {
    private static SmartTabSingleton smartTabSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private SmartTabSingleton(Context context){
        SmartTabSingleton.context = context;
        requestQueue = getRequestQueue();
    }
    public static synchronized SmartTabSingleton getInstance(Context context){
        if (smartTabSingleton == null){
            smartTabSingleton = new SmartTabSingleton(context);
        }
        return smartTabSingleton;
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
