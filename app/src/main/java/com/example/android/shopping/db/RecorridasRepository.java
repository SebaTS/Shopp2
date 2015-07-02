package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Locacion;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Seba on 30/06/2015.
 */
public class RecorridasRepository {

    public ArrayList<String> listaDeRecorridas;

    public RecorridasRepository(ResultSet resultSet) {

        listaDeRecorridas = new ArrayList<String>();
        listaDeRecorridas = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Locacion l = new Locacion(descr);
                listaDeRecorridas.add(l.getDescripcion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
