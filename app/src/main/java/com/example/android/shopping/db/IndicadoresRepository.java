package com.example.android.shopping.db;

import android.widget.Switch;

import com.example.android.shopping.Entidades.Indicador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.zip.InflaterInputStream;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by android on 04/06/2015.
 */
public class IndicadoresRepository {

    public ArrayList<String> listaDeIndicadores;

    // Llena al array con los edificios.
    public IndicadoresRepository(ResultSet resultSet) {

        listaDeIndicadores = new ArrayList<String>();
        listaDeIndicadores = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Indicador e = new Indicador(descr);
                listaDeIndicadores.add(e.getdescr());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*
    private ArrayList<Indicador> listaDeMalls = new ArrayList<Indicador>();
    private ArrayList<Indicador> listaDeBaños = new ArrayList<Indicador>();
    private ArrayList<Indicador> listaDeEstacionamientos = new ArrayList<Indicador>();
    private ArrayList<Indicador> listaDeIndicadores = new ArrayList<Indicador>();
    public int contador;

    public IndicadoresRepository(int i){

        if (i < 5) {
            listaDeMalls.add(new Indicador("Mall", "Limpieza"));
            listaDeMalls.add(new Indicador("Mall", "Pisos"));
            listaDeMalls.add(new Indicador("Mall", "Vidrios"));
            listaDeMalls.add(new Indicador("Mall", "Estado cestos"));
            listaDeMalls.add(new Indicador("Mall", "Estética del cableado"));
            listaDeMalls.add(new Indicador("Mall", "Señalética / Graficas"));
            listaDeMalls.add(new Indicador("Mall", "Aromatización"));
            listaDeMalls.add(new Indicador("Mall", "Fumigación"));
            listaDeMalls.add(new Indicador("Mall", "Estado General"));

            contador = listaDeMalls.size();

        }else if (i < 10) {

            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Limpieza"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Pisos"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Vidrios"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Estado cestos"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Estética del cableado"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Señalética / Graficas"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Aromatización"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Fumigación"));
            listaDeEstacionamientos.add(new Indicador("Estacionamiento", "Estado General"));

            contador = listaDeEstacionamientos.size();

        }else{

            listaDeBaños.add(new Indicador("Baño", "Limpieza"));
            listaDeBaños.add(new Indicador("Baño", "Pisos"));
            listaDeBaños.add(new Indicador("Baño", "Vidrios"));
            listaDeBaños.add(new Indicador("Baño", "Estado cestos"));
            listaDeBaños.add(new Indicador("Baño", "Estética del cableado"));
            listaDeBaños.add(new Indicador("Baño", "Señalética / Graficas"));
            listaDeBaños.add(new Indicador("Baño", "Funcionamiento"));
            listaDeBaños.add(new Indicador("Baño", "Insumos"));
            listaDeBaños.add(new Indicador("Baño", "Aromatización"));
            listaDeBaños.add(new Indicador("Baño", "Fumigación"));
            listaDeBaños.add(new Indicador("Baño", "Estado General"));

            contador = listaDeBaños.size();
        }
    }


    public List<Indicador> getIndicadores(int i) {
        if (i < 5) {

            return listaDeMalls;

        }else if (i < 10) {

            return listaDeEstacionamientos;

        }else{

            return listaDeBaños;
        }
    }
}*/