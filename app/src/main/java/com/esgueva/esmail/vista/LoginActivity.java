package com.esgueva.esmail.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.esgueva.esmail.R;
import com.esgueva.esmail.modelo.Correo;
import com.esgueva.esmail.modelo.Usuario;

import static com.esgueva.esmail.vista.MainActivity.esMail;

public class LoginActivity extends AppCompatActivity {

    private TextView txtUsuario, txtPassword;
    int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPass);

        Button btnAceptar = findViewById(R.id.btnLogear);
        btnAceptar.setOnClickListener(pulsarBoton);
        intentos = 0;
    }

    private View.OnClickListener pulsarBoton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int posUser = posicionEncontrado();

            if (posUser == -1){
                intentos = intentos+1;
                Toast.makeText(LoginActivity.this,getString(R.string.fallo) + " " + (3-intentos) + " " + getString(R.string.intent),Toast.LENGTH_SHORT).show();
                if (intentos == 3){
                    Toast.makeText(LoginActivity.this, R.string.intentos,Toast.LENGTH_SHORT).show();
                    finish();
                }
            }else{
                esMail.setPosUser(posUser);
                Intent intent = new Intent(LoginActivity.this, CorreoActivity.class);
                cargaCorreosDemo();
                startActivity(intent);
            }
        }
    };


    private int posicionEncontrado(){
        int posicion = 0;
        boolean encontrado = false;

        while(posicion < esMail.getUsuarios().size() && !encontrado){

            String txtUser = txtUsuario.getText().toString();
            String user = esMail.getUsuarios().get(posicion).getNombre();

            String txtPass = txtPassword.getText().toString();
            String pass = esMail.getUsuarios().get(posicion).getPassword();

            if (txtUser.compareToIgnoreCase(user)==0  && txtPass.compareToIgnoreCase(pass) == 0) {
                return posicion;
            }
            posicion += 1;
        }

        if (!encontrado) {
            posicion = -1;
        }
        return  posicion;
    }

    //CARGA DE CORREOS PRUEBA USUARIO
    public void cargaCorreosDemo() {
        if (esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().size() == 0) {
            for (int i = 0; i < 3; i++) {
                Usuario user = esMail.getUsuarios().get(0);
                String asunto = "BIENVENIDO A ESMAIL" + i;
                String texto = "Mensaje" + i + " de bienvenida, al servicio de correo esmail. \nPara mas info puede contactar con nosotros en info@esmail.com";
                esMail.getUsuarios().get(esMail.getPosUser()).getCorreos().add(new Correo(user, asunto, texto));
            }
        }
    }
}
