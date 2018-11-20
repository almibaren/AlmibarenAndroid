package com.baren.almi.almibarenandroid;

public class Productos {
    private String url = "";
    private String url2 = "";
    private String url3 = "";
    private String url4 = "";
    private String id = "";
    private String nombre = "";
    private String precio = "";
    private String descuento = "";

    public Productos( String id, String url, String url2, String url3, String url4, String nombre, String precio, String descuento) {
        this.url = url;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
