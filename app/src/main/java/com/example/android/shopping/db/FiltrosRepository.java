package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Filtro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Seba on 12/06/2015.
 */
public class FiltrosRepository {

    public ArrayList<String> listaDeFiltros;

    // Llena el array con los filtros.
    public FiltrosRepository(ResultSet resultSet) {

        listaDeFiltros = new ArrayList<String>();
        //listaDeFiltros = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Filtro f = new Filtro(descr);
                listaDeFiltros.add(f.getfiltro());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*        Filtro malls = new Filtro("Malls");
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
*/