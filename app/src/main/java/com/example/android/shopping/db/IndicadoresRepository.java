package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Indicador;

import java.util.ArrayList;

/**
 * Created by android on 04/06/2015.
 */
public class IndicadoresRepository {

    private ArrayList<Indicador> listaDeIndicadores;
    public IndicadoresRepository(){
        listaDeIndicadores = new ArrayList<Indicador>();

        Indicador mall1 = new Indicador("Mall", "Limpieza");
        Indicador mall2 = new Indicador("Mall", "Pisos");
        Indicador mall3 = new Indicador("Mall", "Vidrios");
        Indicador mall4 = new Indicador("Mall", "Estado cestos");
        Indicador mall5 = new Indicador("Mall", "Estética del cableado");
        Indicador mall6 = new Indicador("Mall", "Señalética / Graficas");
        Indicador mall7 = new Indicador("Mall", "Aromatización");
        Indicador mall8 = new Indicador("Mall", "Fumigación");
        Indicador mall9 = new Indicador("Mall", "Estado General");

        listaDeIndicadores.add (mall1);
        listaDeIndicadores.add (mall2);
        listaDeIndicadores.add (mall3);
        listaDeIndicadores.add (mall4);
        listaDeIndicadores.add (mall5);
        listaDeIndicadores.add (mall6);
        listaDeIndicadores.add (mall7);
        listaDeIndicadores.add (mall8);
        listaDeIndicadores.add (mall9);

        Indicador baño1 = new Indicador ("Baño", "Limpieza");
        Indicador baño2 = new Indicador ("Baño", "Pisos");
        Indicador baño3 = new Indicador ("Baño", "Vidrios");
        Indicador baño4 = new Indicador ("Baño", "Estado cestos");
        Indicador baño5 = new Indicador ("Baño", "Estética del cableado");
        Indicador baño6 = new Indicador ("Baño", "Señalética / Graficas");
        Indicador baño7 = new Indicador ("Baño", "Funcionamiento");
        Indicador baño8 = new Indicador ("Baño", "Insumos");
        Indicador baño9 = new Indicador ("Baño", "Aromatización");
        Indicador baño10 = new Indicador ("Baño", "Fumigación");
        Indicador baño11 = new Indicador ("Baño", "Estado General");

        listaDeIndicadores.add (baño1);
        listaDeIndicadores.add (baño2);
        listaDeIndicadores.add (baño3);
        listaDeIndicadores.add (baño4);
        listaDeIndicadores.add (baño5);
        listaDeIndicadores.add (baño6);
        listaDeIndicadores.add (baño7);
        listaDeIndicadores.add (baño8);
        listaDeIndicadores.add (baño9);
        listaDeIndicadores.add (baño10);
        listaDeIndicadores.add (baño11);

        Indicador bañodis1 = new Indicador ("Baño", "Limpieza");
        Indicador bañodis2 = new Indicador ("Baño", "Pisos");
        Indicador bañodis3 = new Indicador ("Baño", "Barandas");
        Indicador bañodis4 = new Indicador ("Baño", "Vidrios");
        Indicador bañodis5 = new Indicador ("Baño", "Estado cestos");
        Indicador bañodis6 = new Indicador ("Baño", "Estética del cableado");
        Indicador bañodis7 = new Indicador ("Baño", "Señalética / Graficas");
        Indicador bañodis8 = new Indicador ("Baño", "Funcionamiento");
        Indicador bañodis9 = new Indicador ("Baño", "Insumos");
        Indicador bañodis10 = new Indicador ("Baño", "Aromatización");
        Indicador bañodis11 = new Indicador ("Baño", "Fumigación");
        Indicador bañodis12 = new Indicador ("Baño", "Estado General");

        listaDeIndicadores.add (bañodis1);
        listaDeIndicadores.add (bañodis2);
        listaDeIndicadores.add (bañodis3);
        listaDeIndicadores.add (bañodis4);
        listaDeIndicadores.add (bañodis5);
        listaDeIndicadores.add (bañodis6);
        listaDeIndicadores.add (bañodis7);
        listaDeIndicadores.add (bañodis8);
        listaDeIndicadores.add (bañodis9);
        listaDeIndicadores.add (bañodis10);
        listaDeIndicadores.add (bañodis11);
        listaDeIndicadores.add (bañodis12);
    }
}