package com.example.android.shopping.Syncro;

import android.support.v7.app.ActionBarActivity;

import com.example.android.shopping.db.EdificiosRepository;
import com.example.android.shopping.db.EvaluacionesRepository;
import com.example.android.shopping.db.FiltrosRepository;
import com.example.android.shopping.db.IndicadoresRepository;
import com.example.android.shopping.db.LocacionesRepository;
import com.example.android.shopping.db.RecorridasRepository;
import com.example.android.shopping.db.UsuariosRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection extends ActionBarActivity {

    public UsuariosRepository usuariosRepo;
    public EdificiosRepository edificiosRepo;
    public RecorridasRepository recorridasRepo;
    public LocacionesRepository locacionesRepo;
    public FiltrosRepository filtrosRepo;
    public IndicadoresRepository indicadoresRepo;
    public EvaluacionesRepository evaluacionesRepo;



    public Thread sqlUsuarios = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Usuario, Contraseña FROM Usuarios";
                Statement st = conn.createStatement();
                ResultSet resultadoUsuarios = st.executeQuery(stsql);
                usuariosRepo = new UsuariosRepository(resultadoUsuarios);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

//    public Thread sqlEdificios = new Thread() {
//        public void run() {
        public void sqlEdificios(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Edificios";
                Statement st = conn.createStatement();
                ResultSet resultadoEdificios = st.executeQuery(stsql);
                edificiosRepo = new EdificiosRepository(resultadoEdificios);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//    };

//    public Thread sqlRecorridas = new Thread() {
//        public void run() {
        public void sqlRecorridas(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Recorridas";
                Statement st = conn.createStatement();
                ResultSet resultadoRecorridas = st.executeQuery(stsql);
                recorridasRepo = new RecorridasRepository(resultadoRecorridas);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
//    };

    public Thread sqlLocaciones = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Locaciones";
                Statement st = conn.createStatement();
                ResultSet resultadoLocaciones = st.executeQuery(stsql);
                locacionesRepo = new LocacionesRepository(resultadoLocaciones);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public Thread sqlFiltros = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Filtros";
                Statement st = conn.createStatement();
                ResultSet resultadoFiltros = st.executeQuery(stsql);
                filtrosRepo = new FiltrosRepository(resultadoFiltros);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public Thread sqlIndicadores = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Indicadores";
                Statement st = conn.createStatement();
                ResultSet resultadoIndicadores = st.executeQuery(stsql);
                indicadoresRepo = new IndicadoresRepository(resultadoIndicadores);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public Thread sqlEvaluaciones = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://201.231.169.182:3306/shopping", "root", "puerta18");
                String stsql = "SELECT Descripcion FROM Evaluaciones";
                Statement st = conn.createStatement();
                ResultSet resultadoEvaluaciones = st.executeQuery(stsql);
                evaluacionesRepo = new EvaluacionesRepository(resultadoEvaluaciones);
                st.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };
}



