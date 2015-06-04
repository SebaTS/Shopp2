package com.example.android.shopping;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Seba on 30/05/2015.
 */
public class Usuario {

    private String user;
    private String pass;

    public void setuser(String usuario) {
        this.user = usuario;
    }
    public void setpass(String password) {
        this.pass = password;
    }
    public String getuser() {
        return user;
    }
    public String getpass() {
        return pass;
    }

    public Usuario(String usuario, String password) {
        this.setuser(usuario);
        this.setpass(password);
    }


}