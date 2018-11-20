package com.baren.almi.almibarenandroid.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CardViewSingleton {
    private static CardViewSingleton cardViewSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private CardViewSingleton(Context context){
        CardViewSingleton.context = context;         
        requestQueue = getRequestQueue();
    }

    public static synchronized CardViewSingleton getInstance(Context context){
        if (cardViewSingleton==null){
            cardViewSingleton = new CardViewSingleton(context);
        }
        return cardViewSingleton;
    }
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }
}