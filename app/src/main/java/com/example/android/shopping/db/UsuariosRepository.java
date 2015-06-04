package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Usuario;

import java.util.ArrayList;

/**
 * Created by android on 04/06/2015.
 */
public class UsuariosRepository {

    private ArrayList<Usuario> listaDeUsuarios;
    private boolean recordarUsuario;

    public UsuariosRepository() {

        Usuario user = new Usuario("prueba", "prueba");
        listaDeUsuarios = new ArrayList<Usuario>();
        listaDeUsuarios.add(user);

    }

    public boolean existeUsuario(String username, String pwd) {
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
