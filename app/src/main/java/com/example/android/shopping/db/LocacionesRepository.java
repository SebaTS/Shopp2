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

    // Llena al array con las locaciones.
    public LocacionesRepository() {
        Locacion baños = new Locacion("Baños");
        Locacion paco = new Locacion("PaCo");
        Locacion mall = new Locacion("Mall");
        Locacion elevacion = new Locacion("Medios de Elevación");
        Locacion comodities = new Locacion("Comodities");
        Locacion ambiente = new Locacion("Ambiente");
        Locacion señaletica = new Locacion("Señalética");
        Locacion sustentabilidad = new Locacion("Sustentabilidad");
        Locacion seguridad = new Locacion("Medios de Seguridad");
        Locacion promo = new Locacion("Promociones");
        Locacion turismo = new Locacion("Turismo");
        listaDeLocaciones = new ArrayList<String>();
        listaDeLocaciones.add(baños.getDescripcion());
        listaDeLocaciones.add(paco.getDescripcion());
        listaDeLocaciones.add(mall.getDescripcion());
        listaDeLocaciones.add(elevacion.getDescripcion());
        listaDeLocaciones.add(comodities.getDescripcion());
        listaDeLocaciones.add(ambiente.getDescripcion());
        listaDeLocaciones.add(señaletica.getDescripcion());
        listaDeLocaciones.add(sustentabilidad.getDescripcion());
        listaDeLocaciones.add(seguridad.getDescripcion());
        listaDeLocaciones.add(promo.getDescripcion());
        listaDeLocaciones.add(turismo.getDescripcion());
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

    // Devuelve el array de locaciones.
//    public List<Locacion> obtenerTodasLasCategorias() {        return this.listaDeLocaciones;    }
}
