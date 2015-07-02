package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Evaluacion;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Seba on 16/06/2015.
 */
public class EvaluacionesRepository {

    public ArrayList<String> listaDeEvaluaciones;

    public EvaluacionesRepository(ResultSet resultSet) {

        listaDeEvaluaciones = new ArrayList<String>();
        listaDeEvaluaciones = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Evaluacion e = new Evaluacion(descr);
                listaDeEvaluaciones.add(e.getestado());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




/*
    public EvaluacionesRepository(){
        listaDeEvaluaciones = new ArrayList<String>();

        Evaluacion noevaluado = new Evaluacion("No evaluado");
        Evaluacion malo = new Evaluacion("Malo");
        Evaluacion medio = new Evaluacion("Medio");
        Evaluacion bueno = new Evaluacion("Bueno");

        listaDeEvaluaciones.add(noevaluado.getestado());
        listaDeEvaluaciones.add(malo.getestado());
        listaDeEvaluaciones.add(medio.getestado());
        listaDeEvaluaciones.add(bueno.getestado());
    }


}
*/