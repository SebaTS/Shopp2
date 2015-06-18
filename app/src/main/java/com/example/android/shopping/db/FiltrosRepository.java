package com.example.android.shopping.db;

import android.widget.ArrayAdapter;

import com.example.android.shopping.Entidades.Filtro;

import java.util.ArrayList;

/**
 * Created by Seba on 12/06/2015.
 */
public class FiltrosRepository {

    public ArrayList<String> listaDeFiltros;

    // Llena el array con los filtros.
    public FiltrosRepository() {
        Filtro malls = new Filtro("Malls");
        Filtro estacionamientos = new Filtro("Estacionamientos");
        Filtro baños = new Filtro("Baños");
        Filtro ascensores = new Filtro("Ascensores");
        Filtro escalerasm = new Filtro("Escaleras Mecánicas");

        listaDeFiltros = new ArrayList<String>();
        listaDeFiltros.add("Todos");
        listaDeFiltros.add(malls.getfiltro());
        listaDeFiltros.add(estacionamientos.getfiltro());
        listaDeFiltros.add(baños.getfiltro());
        listaDeFiltros.add(ascensores.getfiltro());
        listaDeFiltros.add(escalerasm.getfiltro());


//        public FiltrosRepository(int filtroselec)
//       ("SELECT Descripcion FROM Filtros WHERE Categoria = " + filtroselec);
//       for (int i=0; i <= 30; i++){
//            Filtro filtro = new Filtro("DE LA BD" + i);
//            listaDeFiltros.add(filtro);
//        }
    }
}
