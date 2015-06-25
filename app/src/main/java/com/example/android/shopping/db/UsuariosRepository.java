package com.example.android.shopping.db;

import android.content.Context;
import android.database.Cursor;

import com.example.android.shopping.Entidades.Usuario;

import java.util.ArrayList;

/**
 * Created by android on 04/06/2015.
 */
public class UsuariosRepository {

    private ShoppingDBOpenHelper shoppingDBOpenHelper;
    private ArrayList<Usuario> listaDeUsuarios;
    private boolean recordarUsuario;

    public UsuariosRepository() {

        Usuario user = new Usuario("prueba", "prueba");
        listaDeUsuarios = new ArrayList<Usuario>();
        listaDeUsuarios.add(user);

    }

    public boolean existeUsuario(Context context, String username, String pwd) {
        for (Usuario u : listaDeUsuarios) {
            if (u.getuser().equals(username) && u.getpass().equals(pwd)) {
                return true;
            }
        }
        return false;
//        shoppingDBOpenHelper = new ShoppingDBOpenHelper(context);
//        String selection = shoppingDBOpenHelper.TABLA_USUARIOS_COLUMNA_USUARIO + " = ?";
//        return shoppingDBOpenHelper.existeUsuario(selection, new String[] { username }, null);
    }

    public void setRecordarUsuario(boolean recordarUsuario) {
        this.recordarUsuario = recordarUsuario;
    }
}
