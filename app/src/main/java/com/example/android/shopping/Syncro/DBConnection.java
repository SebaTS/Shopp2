package com.example.android.shopping.Syncro;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.shopping.Entidades.Recorrida;
import com.example.android.shopping.Entidades.Usuario;
import com.example.android.shopping.R;
import com.example.android.shopping.db.EdificiosRepository;
import com.example.android.shopping.db.RecorridasRepository;
import com.example.android.shopping.db.UsuariosRepository;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection extends ActionBarActivity {

    private UsuariosRepository usuariosRepo;

    public Thread sqlThread = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Usuario, Contraseña FROM Usuarios";
                Statement st = conn.createStatement();
//          st.executeUpdate(stsql);
                ResultSet result1 = st.executeQuery(stsql);
/*            while (result1.next()) {
                String usuario = result1.getString("Usuario");
                String contraseña = result1.getString("Contraseña");
                Usuario u = new Usuario(usuario, contraseña);
                usuariosRepo = new UsuariosRepository();
                usuariosRepo.listaDeUsuarios = new ArrayList<Usuario>();
                usuariosRepo.listaDeUsuarios.add(u);
               }*/
                new UsuariosRepository(result1);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public Thread sqlPantallaEdificios = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Edificios";
                Statement st = conn.createStatement();
                ResultSet result2 = st.executeQuery(stsql);
                new EdificiosRepository(result2);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Recorridas";
                Statement st = conn.createStatement();
                ResultSet result3 = st.executeQuery(stsql);
                new RecorridasRepository(result3);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    };

}

    /* PARA CUANDO SE TENGAN QUE FIGURAR LAS LOCACIONES DE LA RECORRIDA

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Locaciones";
                Statement st = conn.createStatement();
                ResultSet result3 = st.executeQuery(stsql);
                new Recorrida(result3);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
     */



