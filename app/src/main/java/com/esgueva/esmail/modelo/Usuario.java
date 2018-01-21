package com.esgueva.esmail.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Usuario implements Parcelable{
    private int imagen;
    private String nombre, password;
    private ArrayList<Correo> correos;

    Usuario(String nombre, String password, int imagen) {
        this.nombre = nombre;
        this.password = password;
        this.imagen=imagen;
        this.correos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nombre;
    }

    int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Correo> getCorreos() {
        return correos;
    }

    private Usuario(Parcel in) {
        imagen = in.readInt();
        nombre = in.readString();
        password = in.readString();
    }

    static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagen);
        parcel.writeString(nombre);
        parcel.writeString(password);
    }
}
