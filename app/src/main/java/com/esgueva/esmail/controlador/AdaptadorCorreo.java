package com.esgueva.esmail.controlador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.esgueva.esmail.modelo.Correo;
import com.esgueva.esmail.R;

import java.util.ArrayList;


public class AdaptadorCorreo extends RecyclerView.Adapter <AdaptadorCorreo.DatosViewHolder> {

    private ArrayList<Correo> correos;

    private OnItemClickListener escucha;

    public AdaptadorCorreo(ArrayList<Correo> correos, OnItemClickListener escucha) {
        this.correos = correos;
        this.escucha = escucha;
    }

    @Override
    public DatosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fila_correos, parent, false);
        return new DatosViewHolder(fila);
    }

    @Override
    public void onBindViewHolder(AdaptadorCorreo.DatosViewHolder holder, int position) {
        Correo correo = correos.get(position);
        holder.getRemitente().setText("Remite: " + correo.getNombreEmisor());
        holder.getAsunto().setText(correo.getAsunto());
        holder.getImagen().setImageResource(correo.getImagenEmisor());
    }

    @Override
    public int getItemCount() {return  correos.size();}


    class DatosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView asunto, remitente;
        private ImageView imagen;

        DatosViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            remitente = itemView.findViewById(R.id.txtRemitente);
            asunto = itemView.findViewById(R.id.txtAsunto);
            imagen = itemView.findViewById(R.id.imagen);

            itemView.setOnClickListener(this);
        }

        TextView getRemitente() { return remitente; }
        TextView getAsunto() {
            return asunto;
        }
        ImageView getImagen(){ return imagen; }

        @Override
        public void onClick(View view) {

            escucha.onClick(this, getAdapterPosition());
        }
    }


    public interface OnItemClickListener
    {
        void onClick(RecyclerView.ViewHolder viewHolder, int posicion);
    }




}
