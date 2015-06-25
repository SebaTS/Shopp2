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
import com.example.android.shopping.Syncro.DBConnection;
import com.example.android.shopping.db.UsuariosRepository;
import net.sourceforge.jtds.jdbc.Driver;

public class PantallaInicio extends ActionBarActivity {

    private EditText userEditText;
    private EditText passEditText;
    private CheckBox sesion;
    private String user;
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
        Connection conn = DBConnection.getInstance().getConnection();
    }

    // Verifica la existencia del usuario Y la contraseña.
    public boolean Verificar() {
        if (this.usuariosRepo.existeUsuario(getApplicationContext(), userEditText.getText().toString(), passEditText.getText().toString())) {
            return true;
        } else {
            msg = Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectas, por favor inténtelo nuevamente.", Toast.LENGTH_SHORT);
            msg.show();
            userEditText.setText("");
            passEditText.setText("");
            return false;
        }
    }

    // Llama a Verificar, si devuelve que existe, avanza a la siguiente página.
    public void Conectar(View view) {
        if (Verificar()) {
            this.usuariosRepo.setRecordarUsuario(sesion.isChecked());
            if (sesion.isChecked()) {

            }
            Intent intent = new Intent(getApplicationContext(), PantallaPlanilla.class);
            String user = userEditText.getText().toString();
            intent.putExtra("Usuario", user);
            startActivity(intent);
        }
    }
}