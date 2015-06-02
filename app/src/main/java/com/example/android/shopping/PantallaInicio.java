package com.example.android.shopping;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class PantallaInicio extends ActionBarActivity {


    ArrayList<Usuarios> listaDeUsuarios;
    private EditText user;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.user = (EditText) this.findViewById(R.id.txtUsuario);
        this.pass = (EditText) this.findViewById(R.id.txtContrasena);
        Usuarios user = new Usuarios("prueba","prueba");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantalla_inicio, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean Verificar() {
        for (Usuarios u : listaDeUsuarios) {
            if (u.getuser().equals(user)) {
                if (u.getpass().equals(pass)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    public void Conectar(){
        if (Verificar()) {
            Intent intent = new Intent(getApplicationContext(), PantallaReportes.class);
            startActivity(intent);
        }
    }
}