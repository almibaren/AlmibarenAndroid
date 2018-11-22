package com.baren.almi.almibarenandroid;

public class Transacciones {
    private String id="";
    private String precio ="";
    private String fecha ="";
    private Productos productos;

    public Transacciones(String id, String precio, String fecha, Productos productos) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
