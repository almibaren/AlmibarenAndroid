package com.baren.almi.almibarenandroid;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Productos {

    private String id = "";
    private String nombre = "";
    private String precio = "";
    private String descuento = "";
    private String url = "";
    private String calculado = "";

    public Productos( String id, String nombre, String precio, String url, String descuento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio + " €";
        this.url = url;
        this.descuento = descuento + "%";
        float calcular;
        calcular = Float.parseFloat(precio)-Float.parseFloat(precio)*Float.parseFloat(descuento)/100;
        BigDecimal bd = new BigDecimal(calcular);
        bd = bd.setScale(2, RoundingMode.HALF_EVEN);
        calcular = bd.floatValue();
        this.calculado = calcular + " €";
    }

    public String getCalculado() {
        return calculado;
    }

    public void setCalculado(String calculado) {
        this.calculado = calculado;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
