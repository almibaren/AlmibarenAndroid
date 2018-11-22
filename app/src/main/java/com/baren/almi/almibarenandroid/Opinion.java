package com.baren.almi.almibarenandroid;

public class Opinion {
    private String user;
    private String valoracion;
    private String comentario;

    public Opinion(String user, String valoracion, String comentario) {
        this.user = user;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
