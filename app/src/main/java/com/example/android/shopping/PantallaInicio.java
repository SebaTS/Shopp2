package com.example.android.shopping;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PantallaInicio extends ActionBarActivity {


    ArrayList<Usuarios> listaDeUsuarios;
    private EditText userEditText;
    private EditText pass;
    Usuarios user;
    Toast msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.userEditText = (EditText) this.findViewById(R.id.txtUsuario);
        this.pass = (EditText) this.findViewById(R.id.txtContrasena);
        user = new Usuarios("prueba","prueba");
        listaDeUsuarios = new ArrayList<Usuarios>();
        listaDeUsuarios.add(user);
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
            if (u.getuser().equals(user.getuser())) {
                if (u.getpass().equals(user.getpass())) {
                    return true;
                }
                msg = Toast.makeText(getApplicationContext(),"Contraseña incorrecta, por favor inténtelo nuevamente.", Toast.LENGTH_SHORT);
                msg.show();
                return false;
            }
        }
        msg = Toast.makeText(getApplicationContext(),"Usuario inexistente, por favor inténtelo nuevamente.", Toast.LENGTH_SHORT);
        msg.show();
        return false;
    }


    public void Conectar(View view) {
        if (Verificar()) {
            Intent intent = new Intent(getApplicationContext(), PantallaReportes.class);
            startActivity(intent);
        }
    }
}