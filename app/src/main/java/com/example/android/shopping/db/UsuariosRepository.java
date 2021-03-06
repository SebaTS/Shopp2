package com.example.android.shopping.db;

import android.content.Context;

import com.example.android.shopping.Entidades.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by android on 04/06/2015.
 */
public class UsuariosRepository {

    public ArrayList<Usuario> listaDeUsuarios;

    private boolean recordarUsuario;

    public UsuariosRepository(ResultSet resultSet) {

        listaDeUsuarios = new ArrayList<Usuario>();
        //listaDeUsuarios = null;
        try {
            while (resultSet.next()) {
                String usuario = resultSet.getString("Usuario");
                String contraseña = resultSet.getString("Contraseña");
                Usuario u = new Usuario(usuario, contraseña);
                listaDeUsuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeUsuario(Context context, String username, String pwd) {
        for (Usuario u : listaDeUsuarios) {
            if (u.getuser().equals(username) && u.getpass().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    public void setRecordarUsuario(boolean recordarUsuario) {
        this.recordarUsuario = recordarUsuario;
    }
}
