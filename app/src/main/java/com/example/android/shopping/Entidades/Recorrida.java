package com.example.android.shopping.Entidades;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Seba on 30/06/2015.
 */
public class Recorrida {

    private String descripcion;

    public void setDescripcion(String recorrida) {
        this.descripcion = recorrida;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public Recorrida(String locacion){
        this.setDescripcion(locacion);
    }
}