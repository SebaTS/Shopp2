package com.example.android.shopping.Syncro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by android on 25/06/2015.
 */
public class DBConnection {

    private static DBConnection instance = null;
    private static final String URL="jdbc:mysql://bossio.dlinkddns.com:3302/shopping";
    private static final String USER="root";
    private static final String PASS="puerta18";
    private static Connection connection = null;

    private DBConnection(){}

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
            (new net.sourceforge.jtds.jdbc.Driver()).getClass();
            conn = DriverManager.getConnection(URL,USER,PASS);
        }   catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

}
