package com.baren.almi.almibarenandroid.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baren.almi.almibarenandroid.R;
import com.baren.almi.almibarenandroid.Session;

public class AjustesFragment extends Fragment {

    private EditText etNombre,etApe1,etApe2,etEmail,etPasswdAnt,etPasswd,etPasswdRep,etImagen;
    private TextView tvTransaccion,tvTarjetaCredito,tvPaypal;
    private Button btnActualizar;
    Session session;
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
        btnActualizar=view.findViewById(R.id.btnActualizar);
        btnActualizar.setEnabled(false);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "asdasdasdasd", Toast.LENGTH_SHORT).show();
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
    private void comprobar(){
        String passwordAnt = etPasswdAnt.getText().toString();
        String password = etPasswd.getText().toString();
        String rePassword = etPasswdRep.getText().toString();
        String nombre = etNombre.getText().toString();
        String ap1 = etApe1.getText().toString();
        String mail = etEmail.getText().toString();
        if (!mail.trim().equals("") && !ap1.trim().equals("") && !nombre.trim().equals("") && password.equals(rePassword) && !password.trim().equals("") && passwordAnt==session.getPassword()){
            btnActualizar.setEnabled(true);
        }else{
            btnActualizar.setEnabled(false);
        }
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
