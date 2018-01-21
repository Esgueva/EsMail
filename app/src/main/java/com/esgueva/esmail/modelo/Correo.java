package com.esgueva.esmail.modelo;

public class Correo {
    private String nombreEmisor;
    private int imagenEmisor;
    private String asunto, texto;

    public Correo(Usuario emisor, String asunto, String texto) {
        this.nombreEmisor = emisor.getNombre();
        this.imagenEmisor = emisor.getImagen();
        this.asunto = asunto;
        this.texto = texto;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public int getImagenEmisor() {
        return imagenEmisor;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getTexto() {
        return texto;
    }

}

