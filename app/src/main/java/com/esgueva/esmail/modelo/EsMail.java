package com.esgueva.esmail.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import com.esgueva.esmail.R;

import java.util.ArrayList;

public class EsMail implements Parcelable{
    private String autor, centro;
    private ArrayList<Usuario> usuarios;
    private int posUser;

    public EsMail(){
        this.autor =  "Autor: Rodrigo Esgueva Ordóñez";
        this.centro = "Centro: San Jose Artesano";
        this.usuarios = new ArrayList<>();
        cargarUsuarios();
    }

    private EsMail(Parcel in) {
        autor = in.readString();
        centro = in.readString();
        usuarios = in.createTypedArrayList(Usuario.CREATOR);
    }

    public static final Creator<EsMail> CREATOR = new Creator<EsMail>() {
        @Override
        public EsMail createFromParcel(Parcel in) {
            return new EsMail(in);
        }

        @Override
        public EsMail[] newArray(int size) {
            return new EsMail[size];
        }
    };

    public String getAutor() {
        return autor;
    }

    public String getCentro() {
        return centro;
    }

    public int getPosUser() {
        return posUser;
    }

    public void setPosUser(int posUser) {
        this.posUser = posUser;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    private void cargarUsuarios(){
        usuarios.add(new Usuario("Esmail", "es" , R.drawable.esmail));
        usuarios.add(new Usuario("Mj", "es" , R.drawable.user0));
        usuarios.add(new Usuario("Esgueva","es",R.drawable.user1));
        usuarios.add(new Usuario("Julia","es",R.drawable.user4));
        usuarios.add(new Usuario("Mario","es",R.drawable.user3));
        usuarios.add(new Usuario("Josefina","es",R.drawable.user2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(autor);
        parcel.writeString(centro);
        parcel.writeTypedList(usuarios);
    }
}
