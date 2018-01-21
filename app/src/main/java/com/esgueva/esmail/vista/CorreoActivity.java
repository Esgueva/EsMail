package com.esgueva.esmail.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.esgueva.esmail.R;

public class CorreoActivity extends AppCompatActivity implements FragmentoLista.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);

        if (findViewById(R.id.fragmento_Contenedor) != null && savedInstanceState == null){
            FragmentoLista lista = new FragmentoLista();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmento_Contenedor,lista).commit();
        }
    }

    @Override
    public void onFragmentInteraction(int pos) {
        FragmentoDetalle detalleFragment = (FragmentoDetalle) getSupportFragmentManager().findFragmentById(R.id.fragment_detalle);
        if (detalleFragment !=null){
            detalleFragment.cambio(pos);
        }else{
            FragmentoDetalle nuevo = new FragmentoDetalle();
            Bundle args = new Bundle();
            args.putInt("pos", pos);
            nuevo.setArguments(args);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmento_Contenedor,nuevo)
                    .addToBackStack(null).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_correo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mEnviar:
                Intent intent = new Intent(CorreoActivity.this, EdicionActivity.class);
                startActivity(intent);
                break;

            case R.id.mDesconectar:
                this.finish();
                break;
        }
    return super.onOptionsItemSelected(item);
    }
}
