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
//import com.example.android.shopping.Syncro.DBConnection;
import com.example.android.shopping.db.UsuariosRepository;
import com.example.android.shopping.Syncro.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PantallaInicio extends ActionBarActivity {

    private EditText userEditText;
    private EditText passEditText;
    private CheckBox sesion;
    private String user;
    Toast msg;
    private UsuariosRepository usuariosRepo;
    private DBConnection ea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        this.userEditText = (EditText) this.findViewById(R.id.txtUsuario);
        this.passEditText = (EditText) this.findViewById(R.id.txtContrasena);
        this.sesion = (CheckBox) this.findViewById(R.id.chkSesion);
//       sqlThread.start();
//        this.usuariosRepo = new UsuariosRepository();
        this.ea = new DBConnection();
        ea.sqlThread.start();
    }
/*
    Thread sqlThread = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Usuario, Contraseña FROM Usuarios";
                Statement st = conn.createStatement();
//          st.executeUpdate(stsql);
                ResultSet result1 = st.executeQuery(stsql);
                while (result1.next()) {
                    String usuario = result1.getString("Usuario");
                    String contraseña = result1.getString("Contraseña");
                    Usuario u = new Usuario(usuario, contraseña);
                    usuariosRepo = new UsuariosRepository();
                    usuariosRepo.listaDeUsuarios = new ArrayList<Usuario>();
                    usuariosRepo.listaDeUsuarios.add(u);
                }
//            new UsuariosRepository(result1);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };
*/
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