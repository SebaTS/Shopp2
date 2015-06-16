package com.example.android.shopping.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.android.shopping.Entidades.Locacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 04/06/2015.
 */
public class LocacionesRepository {

    public ArrayList<String> listaDeLocaciones;
    public ArrayList<String> listaDeLocacionesBaños;
    public ArrayList<String> listaDeLocacionesMall;

    // Llena al array con las locaciones.
    public LocacionesRepository() {

        listaDeLocaciones = new ArrayList<String>();
        listaDeLocacionesBaños = new ArrayList<String>();
        listaDeLocacionesMall = new ArrayList<String>();

        Locacion baño1 = new Locacion("Baños- nivel pb (Masc)");
        Locacion baño2 = new Locacion("Baños- nivel pb (Fem)");
        Locacion baño3 = new Locacion("Baños- nivel pb (discap)");
        Locacion baño4 = new Locacion("Baños- nivel 1° Agüero (masc)");
        Locacion baño5 = new Locacion("Baños- nivel 1° Agüero (fem)");

        listaDeLocaciones.add(baño1.getDescripcion());
        listaDeLocaciones.add(baño2.getDescripcion());
        listaDeLocaciones.add(baño3.getDescripcion());
        listaDeLocaciones.add(baño4.getDescripcion());
        listaDeLocaciones.add(baño5.getDescripcion());

        listaDeLocacionesBaños.add(baño1.getDescripcion());
        listaDeLocacionesBaños.add(baño2.getDescripcion());
        listaDeLocacionesBaños.add(baño3.getDescripcion());
        listaDeLocacionesBaños.add(baño4.getDescripcion());
        listaDeLocacionesBaños.add(baño5.getDescripcion());

        Locacion mall1 = new Locacion ("Mall Acceso Corrientes");
        Locacion mall2 = new Locacion ("Mall Acceso Anchorena");
        Locacion mall3 = new Locacion ("Mall Acceso Agüero");
        Locacion mall4 = new Locacion ("Mall Acceso Anchorena 1°");
        Locacion mall5 = new Locacion ("Mall Acceso Agüero 1°");

        listaDeLocaciones.add(mall1.getDescripcion());
        listaDeLocaciones.add(mall2.getDescripcion());
        listaDeLocaciones.add(mall3.getDescripcion());
        listaDeLocaciones.add(mall4.getDescripcion());
        listaDeLocaciones.add(mall5.getDescripcion());

        listaDeLocacionesMall.add(mall1.getDescripcion());
        listaDeLocacionesMall.add(mall2.getDescripcion());
        listaDeLocacionesMall.add(mall3.getDescripcion());
        listaDeLocacionesMall.add(mall4.getDescripcion());
        listaDeLocacionesMall.add(mall5.getDescripcion());
    }

    // Limpia el array, llenandolo con las locaciones que cumplan con el filtro.
    public void MostrarLocaciones(String filtro){
        listaDeLocaciones.clear();
        if (filtro.equals("Baños")){
            Locacion baños = new Locacion("Baños");
            listaDeLocaciones.add(baños.getDescripcion());
        } else{
            Locacion mall = new Locacion("Mall");
            listaDeLocaciones.add(mall.getDescripcion());
        }
    }

    public ArrayList<String> obtenerLocaciones(int filtro) {
        ArrayList<String> locaciones = null;

        switch (filtro){
            case 0 :
                locaciones = listaDeLocaciones;
                break;
            case 1 :
                locaciones = listaDeLocacionesBaños;
                break;
            case 2 :
                locaciones = listaDeLocacionesMall;
                break;
            default :
                locaciones = null;
                break;
        }

        return locaciones;
    }

    // Devuelve el array de locaciones.
//    public List<Locacion> obtenerTodasLasCategorias() {        return this.listaDeLocaciones;    }
}
