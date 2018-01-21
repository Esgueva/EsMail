package com.esgueva.esmail.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.esgueva.esmail.R;
import com.esgueva.esmail.modelo.EsMail;


public class MainActivity extends AppCompatActivity {

        static EsMail esMail;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            esMail = new EsMail();
            Button btnInicio = findViewById(R.id.btnInicio);
            btnInicio.setOnClickListener(click);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(MainActivity.this, AutorActivity.class);
        intent.putExtra("esMail",esMail);
        startActivity(intent);
        return true;
    }

    private View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.esgueva.esmail.vista.LoginActivity.class);
                intent.putExtra("esMail",esMail);
                startActivity(intent);
            }
        };

}
