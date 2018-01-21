package com.esgueva.esmail.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.esgueva.esmail.R;
import com.esgueva.esmail.modelo.EsMail;

public class AutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        TextView txtAutor = findViewById(R.id.txtAutor);
        TextView txtCentro = findViewById(R.id.txtCentro);

        // PODRIA SACAR LOS DATOS DE ESMAIL DIRECTAMENTE AL SER STATIC
        // PERO HE QUERIDO TRABAJAR CON PARCELABLE PARA HACER EL EJERCICIO MAS COMPLETO.

        EsMail esMail = getIntent().getParcelableExtra("esMail");
        String autor = esMail.getAutor();
        String centro = esMail.getCentro();

        txtAutor.setText(autor);
        txtCentro.setText(centro);

    }
}
