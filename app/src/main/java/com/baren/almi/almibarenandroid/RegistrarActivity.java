package com.baren.almi.almibarenandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baren.almi.almibarenandroid.singleton.UsuarioSingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrarActivity extends AppCompatActivity {

    private String URL_BASE ="http://192.168.6.161/almibarenBackend/users/signup/";
    private EditText etDNI,etNombre,etAp1,etAp2,etEmail,etUser,etPasswd,etPasswdRepe,etImagen;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        etDNI= findViewById(R.id.etRegDNI);
        etNombre=findViewById(R.id.etRegNombre);
        etAp1=findViewById(R.id.etRegApellido1);
        etAp2=findViewById(R.id.etRegApellido2);
        etEmail=findViewById(R.id.etRegMail);
        etUser=findViewById(R.id.etRegUser);
        etPasswd=findViewById(R.id.etRegPasswd);
        etPasswdRepe=findViewById(R.id.etRegPasswd1);
        etImagen=findViewById(R.id.etRegImg);
        btnRegistrar=findViewById(R.id.btnRegistrar);
        btnRegistrar.setEnabled(false);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    insertar();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
        etPasswdRepe.addTextChangedListener(new TextWatcher()
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
                String rePassword = etPasswdRepe.getText().toString();

                if(!password.equals(rePassword))
                {
                    etPasswdRepe.setBackgroundColor(Color.RED);
                    comprobar();
                } else
                {
                    etPasswdRepe.setBackgroundColor(Color.WHITE);
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
                String rePassword = etPasswdRepe.getText().toString();

                if(!password.equals(rePassword))
                {
                    etPasswdRepe.setBackgroundColor(Color.RED);
                    comprobar();
                } else
                {
                    etPasswdRepe.setBackgroundColor(Color.WHITE);
                    comprobar();
                }
            }
        });
        etUser.addTextChangedListener(new TextWatcher()
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
                comprobar();
            }
        });
        etDNI.addTextChangedListener(new TextWatcher()
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
            public void afterTextChanged(Editable s){
                comprobar();
            }

        });
        etNombre.addTextChangedListener(new TextWatcher()
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
                comprobar();
            }
        });

        etAp1.addTextChangedListener(new TextWatcher()
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
                comprobar();
            }
        });

        etEmail.addTextChangedListener(new TextWatcher()
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
                comprobar();
            }
        });

    }

    private void insertar() throws JSONException{
        JsonObjectRequest petisao;
        String url = URL_BASE;

        final JSONObject objUsuario= new JSONObject();

        objUsuario.put("dni",etDNI.getText().toString());
        objUsuario.put("nombre",etNombre.getText().toString());
        objUsuario.put("apellido1",etAp1.getText().toString());
        objUsuario.put("apellido2",etAp2.getText().toString());
        objUsuario.put("email",etEmail.getText().toString());
        objUsuario.put("user",etUser.getText().toString());
        objUsuario.put("passwd",etPasswd.getText().toString());
        objUsuario.put("imagen",etImagen.getText().toString());

        petisao=new JsonObjectRequest(Request.Method.POST, url, objUsuario, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("asier ", error.toString());
            }
        });
        UsuarioSingleton.getInstance(getApplicationContext()).addToRequestQueue(petisao);

    }

    private void comprobar(){

        String password = etPasswd.getText().toString();
        String rePassword = etPasswdRepe.getText().toString();
        String user = etUser.getText().toString();
        String dni = etDNI.getText().toString();
        String nombre = etNombre.getText().toString();
        String ap1 = etAp1.getText().toString();
        String mail = etEmail.getText().toString();
        if (!mail.trim().equals("") && !ap1.trim().equals("") && !nombre.trim().equals("") && !dni.trim().equals("") && !user.trim().equals("") && password.equals(rePassword) && !password.trim().equals("")){
            btnRegistrar.setEnabled(true);
        }else{
            btnRegistrar.setEnabled(false);
        }
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
