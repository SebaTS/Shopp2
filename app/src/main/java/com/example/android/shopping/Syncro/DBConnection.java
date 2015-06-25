package com.example.android.shopping.Syncro;

import android.util.Log;
import android.widget.Toast;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.content.Context;



public class DBConnection {


    Connection conn;
    String resultadoConexion;

    @Override
    protected String doInBackground(String... urls) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://1111111/xxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("CONEXION AsyncTask:   " + conn);
            Log.i("Exito", "Conexion a la base de datos realizada con exito");
            resultadoConexion = "Conectado";
        } catch (Exception e) {
            resultadoConexion = "Error al conectar";
            Log.i("ErrorBBDD", "Error: " + e.getMessage());
            e.printStackTrace();
        }
        return resultadoConexion;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}






    /*
    public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        if (connection == null){
            connection = conectar();
        }
        return connection;
    }

    private Connection conectar(){
        Connection conn = null;
        try{
            (new Driver()).getClass();
            conn = DriverManager.getConnection(URL,USER,PASS);
        }   catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

}
