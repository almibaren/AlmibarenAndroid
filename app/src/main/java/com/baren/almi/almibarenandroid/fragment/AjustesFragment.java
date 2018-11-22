package com.baren.almi.almibarenandroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.MainActivity;
import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.Session;
import com.baren.almi.almibarenandroid.Transacciones;
import com.baren.almi.almibarenandroid.adapter.AjustesAdapter;
import com.baren.almi.almibarenandroid.adapter.recycler.CompraAjusteRVAdapter;
import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AjustesFragment extends Fragment {
    private String URL_BASE ="https://192.168.6.161/almibarenBackend/users/";
    private EditText etNombre,etApe1,etApe2,etEmail,etPasswdAnt,etPasswd,etPasswdRep,etImagen;
    private Button btnActualizar;
    Session session;
   private RecyclerView rvCompra,rvAlquiler,rvReparacion,rvValoracion;
    public AjustesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_ajustes,container,false);
        return vista;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        session=new Session(getContext());
        etImagen=view.findViewById(R.id.etImagenUsu);
        etNombre=view.findViewById(R.id.etNomUsu);
        etNombre.setText(session.getNombre());
        etApe1=view.findViewById(R.id.etAp1Usu);
        etApe1.setText(session.getApellido1());
        etApe2=view.findViewById(R.id.etAp2Usu);
        etApe2.setText(session.getApellido2());
        etEmail=view.findViewById(R.id.etEmailUsu);
        etEmail.setText(session.getEmail());
        etPasswdAnt=view.findViewById(R.id.etPasswdAntig);
        etPasswd=view.findViewById(R.id.etPasswdNueva);
        etPasswdRep=view.findViewById(R.id.etPasswdNuevaComp);

        rvCompra=view.findViewById(R.id.lvCompraTransaccAjuste);
        rvAlquiler=view.findViewById(R.id.lvAlquiTransaccAjuste);
        rvReparacion=view.findViewById(R.id.lvRepTransaccAjuste);
        rvValoracion=view.findViewById(R.id.lvValoTransaccAjuste);

        llenarCompras();

        btnActualizar=view.findViewById(R.id.btnActualizar);
        btnActualizar.setEnabled(false);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    actualizar();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });

        etPasswdAnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etPasswdAnt.getText().toString().equals(session.getPassword())){
                    etPasswdAnt.setBackgroundColor(Color.parseColor("#dddddd"));
                }else{
                    etPasswdAnt.setBackgroundColor(Color.RED);
                }
            comprobar();
            }
        });

        etPasswdRep.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                comprobar();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                String password = etPasswd.getText().toString();
                String rePassword = etPasswdRep.getText().toString();

                if(!password.equals(rePassword))
                {
                    etPasswdRep.setBackgroundColor(Color.RED);
                    comprobar();
                } else
                {
                    etPasswdRep.setBackgroundColor(Color.parseColor("#dddddd"));
                    comprobar();
                }
            }
        });
        etPasswd.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                comprobar();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                String password = etPasswd.getText().toString();
                String rePassword = etPasswdRep.getText().toString();

                if(!password.equals(rePassword))
                {
                    etPasswdRep.setBackgroundColor(Color.RED);
                    comprobar();
                } else
                {
                    etPasswdRep.setBackgroundColor(Color.parseColor("#dddddd"));
                    comprobar();
                }
            }
        });

        etNombre.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                comprobar();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                comprobar();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                comprobar();
            }
        });

        etApe1.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                comprobar();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                comprobar();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                comprobar();
            }
        });

        etEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                comprobar();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                comprobar();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                comprobar();
            }
        });


    }

    private void actualizar() throws JSONException {
        JsonObjectRequest petisao;
        String url = URL_BASE;

        final JSONObject objUsuario= new JSONObject();

        objUsuario.put("dni",session.getDni());
        objUsuario.put("nombre",etNombre.getText().toString());
        objUsuario.put("apellido1",etApe1.getText().toString());
        objUsuario.put("apellido2",etApe2.getText().toString());
        objUsuario.put("email",etEmail.getText().toString());
        objUsuario.put("user",session.getUser());
        objUsuario.put("passwd",etPasswd.getText().toString());
        if(etImagen.getText().equals("Escriba aqui una Url para cambiar la imagen")){
            objUsuario.put("imagen","");
        }else{
        objUsuario.put("imagen",etImagen.getText().toString());
        }
        petisao=new JsonObjectRequest(Request.Method.POST, url, objUsuario, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                session.borrarSesion(((MainActivity)getActivity()).getMenu(),((MainActivity)getActivity()).getHeader(),getContext());
                Toast.makeText(getContext(), "Actualizado con exito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        UsuarioSingleton.getInstance(getContext()).addToRequestQueue(petisao);
    }

    private void comprobar(){
        String passwordAnt = etPasswdAnt.getText().toString();
        String password = etPasswd.getText().toString();
        String rePassword = etPasswdRep.getText().toString();
        String nombre = etNombre.getText().toString();
        String ap1 = etApe1.getText().toString();
        String mail = etEmail.getText().toString();
        if (!mail.trim().equals("") && !ap1.trim().equals("") && !nombre.trim().equals("") && password.equals(rePassword) && !password.trim().equals("") && passwordAnt.equals(session.getPassword())){
            btnActualizar.setEnabled(true);
        }else{
            btnActualizar.setEnabled(false);
        }
    }

    private void llenarCompras(){

        LinearLayoutManager compra = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCompra.setLayoutManager(compra);
        AjustesAdapter ajus=new AjustesAdapter(getContext());
        List<Transacciones> compras=new ArrayList<Transacciones>();
        CompraAjusteRVAdapter compraAjusteRVAdapter = new CompraAjusteRVAdapter(getContext(),compras);
        ajus.cargarCompras(compras,compraAjusteRVAdapter);
        rvCompra.setAdapter(compraAjusteRVAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
