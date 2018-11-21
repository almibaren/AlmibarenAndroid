package com.baren.almi.almibarenandroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.MainActivity;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.RegistrarActivity;
import com.baren.almi.almibarenandroid.Session;
import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONException;
import org.json.JSONObject;


public class IniciarSesionFragment extends Fragment {
    public IniciarSesionFragment() {
    }
    private String URL_BASE="https://almibar.webcindario.com/almibarenBackend/users/login/";
    private EditText etUser,etPasswd;
    private Button btnInicSesion;
    private Session session;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View vista = inflater.inflate(R.layout.fragment_iniciar_sesion,container,false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        etUser=view.findViewById(R.id.etUser);
        etPasswd=view.findViewById(R.id.etPasswd);
        btnInicSesion=view.findViewById(R.id.btnInicSesion);
        session = new Session(getContext());
        btnInicSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    logear(session);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
        TextView tvRegistrar = view.findViewById(R.id.txtNoRegistrado);
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RegistrarActivity.class);
                startActivity(intent);
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void logear(final Session session) throws JSONException {
        JsonObjectRequest petisao;
        String url = URL_BASE;

        final JSONObject objUsuario= new JSONObject();
        objUsuario.put("user",etUser.getText().toString());
        objUsuario.put("passwd",etPasswd.getText().toString());

        petisao=new JsonObjectRequest(Request.Method.POST, url, objUsuario, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    session.setDni(response.getString("dni"));
                    session.setNombre(response.getString("nombre"));
                    session.setApellido1(response.getString("apellido1"));
                    session.setApellido2(response.getString("apellido2"));
                    session.setEmail(response.getString("email"));
                    session.setUser(response.getString("user"));
                    session.setPassword(response.getString("passwd"));
                    session.setImagen(response.getString("imagen"));
                    session.AbrirSession(((MainActivity)getActivity()).getMenu(),((MainActivity)getActivity()).getHeader(),getContext());

                }catch (JSONException e ){
                e.printStackTrace();
            }
                MainFragment mainFragment =new MainFragment();
                mainFragment.setActivity((MainActivity) getActivity());
                Toast.makeText(getContext(), "Inicio de Sesion con exito", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.contentMain,mainFragment).commit();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Contraseña o Usuario incorrectas", Toast.LENGTH_SHORT).show();
                Log.d("asier ", error.toString());
            }
        });
        UsuarioSingleton.getInstance(getContext()).addToRequestQueue(petisao);

    }
}
