package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.android.shopping.R;
import com.example.android.shopping.Syncro.DBConnection;

public class PantallaInicio extends ActionBarActivity {

    private EditText userEditText;
    private EditText passEditText;
    private CheckBox sesion;
    Toast msg;
    private DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.userEditText = (EditText) this.findViewById(R.id.txtUsuario);
        this.passEditText = (EditText) this.findViewById(R.id.txtContrasena);
        this.sesion = (CheckBox) this.findViewById(R.id.chkSesion);

        this.db = new DBConnection();
        db.sqlUsuarios.start();
        db.sqlEdificios.start();
    }

/*--------------------------------------------------------------------------------------------------
-------------------------------------- Private/helper methods --------------------------------------
--------------------------------------------------------------------------------------------------*/
    // Llama a Verificar, si devuelve que existe, avanza a la siguiente página.
    public void Conectar(View view) {

        if (Verificar()) {
            db.usuariosRepo.setRecordarUsuario(sesion.isChecked());
            if (sesion.isChecked()) {
            }
            Intent intent = new Intent(getApplicationContext(), PantallaEdificios.class);
            String user = userEditText.getText().toString();
            intent.putExtra("Usuario", user);
//            intent.putExtra("DB", db);
            startActivity(intent);
        }
    }
//--------------------------------------------------------------------------------------------------
    // Verifica la existencia del usuario Y la contraseña.
    public boolean Verificar() {
        if (db.usuariosRepo.existeUsuario(getApplicationContext(), userEditText.getText().toString(), passEditText.getText().toString())) {
            return true;
        } else {
            msg = Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectas, por favor inténtelo nuevamente.", Toast.LENGTH_SHORT);
            msg.show();
            userEditText.setText("");
            passEditText.setText("");
            return false;
        }
    }
}