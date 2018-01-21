package com.esgueva.esmail.vista;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esgueva.esmail.R;
import com.esgueva.esmail.controlador.AdaptadorCorreo;
import com.esgueva.esmail.modelo.Correo;

import java.util.ArrayList;

import static com.esgueva.esmail.vista.MainActivity.esMail;

//tools:context="com.esgueva.esmail.vista.FragmentoLista"

public class FragmentoLista extends Fragment implements AdaptadorCorreo.OnItemClickListener {

    private OnFragmentInteractionListener mListener;
    RecyclerView reciclado;

    public FragmentoLista() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento_lista, container, false);
        reciclado = v.findViewById(R.id.reciclador);
        return v;
    }

    public void onClick(RecyclerView.ViewHolder viewHolder, int pos){
        if (mListener != null) {
            mListener.onFragmentInteraction(pos);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        ArrayList<Correo>correos =  esMail.getUsuarios().get(esMail.getPosUser()).getCorreos();
        LinearLayoutManager l = new LinearLayoutManager(getActivity());
        l.setOrientation(LinearLayoutManager.VERTICAL);
        reciclado.setLayoutManager(l);
        reciclado.setAdapter(new AdaptadorCorreo(correos,this));
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int pos);
    }
}