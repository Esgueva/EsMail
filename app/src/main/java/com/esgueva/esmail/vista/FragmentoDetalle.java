package com.esgueva.esmail.vista;



import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esgueva.esmail.R;

import static com.esgueva.esmail.vista.MainActivity.esMail;

//tools:context="com.esgueva.esmail.vista.FragmentoDetalle"

public class FragmentoDetalle extends Fragment {

    TextView txtNombreRemite, txtAsunto, txtTexto;
    ImageView imgRemitente;


    public FragmentoDetalle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragmento_detalle, container, false);
        Bundle args = getArguments();

            if (args != null){
                int pos = args.getInt("pos");
                actualizar (pos, v);
            } else {
                actualizar(0, v);
            }

        return v;
    }



    //Permite cambiar actualizar el fragment desde el MainActivity
    public void cambio(int pos){
        actualizar(pos,getView());
    }

    //Permite actualizar los cambios de cada campo
    private void actualizar(Integer posicion, View v){



        txtNombreRemite = v.findViewById(R.id.txtNombreRemite);
        txtAsunto = v.findViewById(R.id.txtAsunto);
        txtTexto = v.findViewById(R.id.txtTexto);
        imgRemitente = v.findViewById(R.id.imgRemitente);

        txtNombreRemite.setText(esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().get(posicion).getNombreEmisor());
        txtAsunto.setText(esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().get(posicion).getAsunto());
        txtTexto.setText(esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().get(posicion).getTexto());
        imgRemitente.setImageResource(esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().get(posicion).getImagenEmisor());
    }

}
