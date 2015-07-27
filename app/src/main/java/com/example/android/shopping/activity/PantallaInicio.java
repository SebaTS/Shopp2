package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.android.shopping.R;
import com.example.android.shopping.Syncro.DBConnection;

public class PantallaInicio extends ActionBarActivity {

    private EditText userEditText;
    private EditText passEditText;
    public Button conectarButton;
    public DBConnection db;
    Toast msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.userEditText = (EditText) this.findViewById(R.id.txtUsuario);
        this.passEditText = (EditText) this.findViewById(R.id.txtContrasena);
        this.conectarButton = (Button) this.findViewById(R.id.btnConectar);
        //conectarButton.setEnabled(false);

        db = db.crearDBConnection();
        db.sqlUsuarios.start();
        esperandoConnection.start();
        msg = Toast.makeText(getApplicationContext(), "Conectando con el servidor. Aguarde un momento.", Toast.LENGTH_LONG);
        msg.show();
    }

/*--------------------------------------------------------------------------------------------------
-------------------------------------- Private/helper methods --------------------------------------
--------------------------------------------------------------------------------------------------*/
    // Llama a Verificar, si devuelve que existe, avanza al siguiente activity.
    public void Conectar(View view) {
        if (Verificar()) {
            Intent intent = new Intent(getApplicationContext(), PantallaEdificios.class);
            String user = userEditText.getText().toString();
            intent.putExtra("Usuario", user);
            startActivity(intent);
        }
    }
//--------------------------------------------------------------------------------------------------
    // Verifica la existencia del usuario y la contraseña.
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
//--------------------------------------------------------------------------------------------------
    // Cambios mientras la conexión se genera y cuando se obtiene.
    private Thread esperandoConnection = new Thread() {
        public void run() {
            while (db.sqlUsuarios.isAlive()) {}
            //conectarButton.setEnabled(true);
        }
    };
}