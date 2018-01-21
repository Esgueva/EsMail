package com.esgueva.esmail.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.esgueva.esmail.R;
import com.esgueva.esmail.modelo.Correo;
import com.esgueva.esmail.modelo.Usuario;

import static com.esgueva.esmail.vista.MainActivity.esMail;

public class EdicionActivity extends AppCompatActivity {

    private TextView txtAsunto, txtTexto;
    private int posDestinatario = 0;
    private int posUser;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        posUser = esMail.getPosUser();

        ArrayAdapter<Usuario> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, esMail.getUsuarios());
        spinner = findViewById(R.id.spinnerUser);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(pulsacion);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        txtAsunto = findViewById(R.id.txtAsuntoE);
        txtTexto = findViewById(R.id.txtTextoE);

        btnEnviar.setOnClickListener(click);

    }

    private AdapterView.OnItemSelectedListener pulsacion = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            posDestinatario = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_edicion,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setResult(1);
        finish();
        return true;
    }


    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        Usuario remitente = esMail.getUsuarios().get(posUser);
        String asunto = txtAsunto.getText().toString();
        String texto = txtTexto.getText().toString();

        Correo c = new Correo(remitente, asunto, texto);

        esMail.getUsuarios().get(posDestinatario).getCorreos().add(c);
        Toast.makeText(EdicionActivity.this, getString(R.string.enviado) + esMail.getUsuarios().get(posDestinatario).getNombre() + ".", Toast.LENGTH_SHORT).show();

        txtAsunto.setText("");
        txtTexto.setText("");
        spinner.setSelection(0);
        }
    };
}
