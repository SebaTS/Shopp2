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
        Filtro baños = new Filtro("Baños");
        Filtro mall = new Filtro("Mall");
        listaDeFiltros = new ArrayList<String>();
        listaDeFiltros.add("Todos");
        listaDeFiltros.add(baños.getfiltro());
        listaDeFiltros.add(mall.getfiltro());

//        public FiltrosRepository(int filtroselec)
//       ("SELECT Descripcion FROM Filtros WHERE Categoria = " + filtroselec);
//       for (int i=0; i <= 30; i++){
//            Filtro filtro = new Filtro("DE LA BD" + i);
//            listaDeFiltros.add(filtro);
//        }
    }
}
