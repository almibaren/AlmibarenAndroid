package com.baren.almi.almibarenandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Session {
    private SharedPreferences prefs;

    public Session(Context context) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void AbrirSession(Menu item, View header, Context context){

        if(getUser()!="") {
            MenuItem inicSesion = item.findItem(R.id.sesion);
            inicSesion.setIcon(R.drawable.ic_logout);
            inicSesion.setTitle("Cerrar Sesion");
            ImageView imageView = header.findViewById(R.id.imagenUsu);
            if(getImagen()!=null){
                Glide.with(context).load(getImagen()).into(imageView);
            }else{
                imageView.setImageIcon(Icon.createWithResource(context,R.drawable.ic_inic_sesion));
            }
            TextView nomUser = header.findViewById(R.id.nombreUsuario);
            nomUser.setText(getUser());
            TextView mailUser = header.findViewById(R.id.correoUsuario);
            mailUser.setText(getEmail());
        }

    }

    public void setUser(String user) {
        prefs.edit().putString("user", user).commit();

    }

    public String getUser() {
        String user = prefs.getString("user","");
        return user;
    }

    public void setPassword(String password) {
        prefs.edit().putString("password", password).commit();
    }

    public String getPassword() {
        String password = prefs.getString("password","");
        return password;
    }

    public void setNombre(String nombre) {
        prefs.edit().putString("nombre", nombre).commit();
    }

    public String getNombre() {
        String nombre = prefs.getString("nombre","");
        return nombre;
    }

    public void setApellido1(String apellido1) {
        prefs.edit().putString("apellido1", apellido1).commit();
    }
    public String getApellido1() {
        String apellido1 = prefs.getString("apellido1","");
        return apellido1;
    }

    public void setApellido2(String apellido2) {
        prefs.edit().putString("apellido2", apellido2).commit();
    }

    public String getApellido2() {
        String apellido2 = prefs.getString("apellido2","");
        return apellido2;
    }

    public void setEmail(String email) {
        prefs.edit().putString("email", email).commit();
    }

    public String getEmail() {
        String email = prefs.getString("email","");
        return email;
    }

    public void setImagen(String imagen) {
        prefs.edit().putString("imagen", imagen).commit();
    }

    public String getImagen() {
        String imagen = prefs.getString("imagen","");
        return imagen;
    }

    public void setDni(String dni) {
        prefs.edit().putString("dni", dni).commit();
    }

    public String getDni() {
        String dni = prefs.getString("dni","");
        return dni;
    }


    public void borrarSesion(Menu item, View header, Context context){
        prefs.edit().clear().commit();
            MenuItem inicSesion = item.findItem(R.id.sesion);
            inicSesion.setIcon(R.drawable.ic_inic_sesion);
            inicSesion.setTitle("Iniciar Sesión");
            ImageView imageView = header.findViewById(R.id.imagenUsu);
            Glide.with(context).load(R.drawable.ic_inic_sesion).into(imageView);
            TextView nomUser = header.findViewById(R.id.nombreUsuario);
            nomUser.setText("");
            TextView mailUser = header.findViewById(R.id.correoUsuario);
            mailUser.setText("");
    }
}
