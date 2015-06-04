package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.shopping.R;
import com.example.android.shopping.Entidades.Usuario;
import com.example.android.shopping.db.UsuariosRepository;

public class PantallaInicio extends ActionBarActivity {

    private EditText userEditText;
    private EditText passEditText;
    private CheckBox sesion;
    Usuario user;
    Toast msg;
    private UsuariosRepository usuariosRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.userEditText = (EditText) this.findViewById(R.id.txtUsuario);
        this.passEditText = (EditText) this.findViewById(R.id.txtContrasena);
        this.sesion = (CheckBox) this.findViewById(R.id.chkSesion);

        this.usuariosRepo = new UsuariosRepository();

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
        if (this.usuariosRepo.existeUsuario(userEditText.getText().toString(), passEditText.getText().toString())) {
            return true;
        } else {
            msg = Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectas, por favor inténtelo nuevamente.", Toast.LENGTH_SHORT);
            msg.show();
            return false;
        }
    }


    public void Conectar(View view) {
        if (Verificar()) {
            this.usuariosRepo.setRecordarUsuario(sesion.isChecked());
            if (sesion.isChecked()) {

            }
            Intent intent = new Intent(getApplicationContext(), PantallaReportes.class);
            startActivity(intent);
        }
    }
}