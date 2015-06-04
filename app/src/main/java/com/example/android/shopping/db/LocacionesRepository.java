package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Locacion;
import java.util.ArrayList;

/**
 * Created by android on 04/06/2015.
 */
public class LocacionesRepository {

    private ArrayList<Locacion> listaDeLocaciones;

    public LocacionesRepository() {

        Locacion baños = new Locacion("Baños");
        Locacion paco = new Locacion ("PaCo");
        Locacion mall = new Locacion ("Mall");
        Locacion elevacion = new Locacion ("Medios de Elevación");
        Locacion comodities = new Locacion ("Comodities");
        Locacion ambiente = new Locacion ("Ambiente");
        Locacion señaletica = new Locacion ("Señalética");
        Locacion sustentabilidad = new Locacion ("Sustentabilidad");
        Locacion seguridad = new Locacion ("Medios de Seguridad");
        Locacion promo = new Locacion ("Promociones");
        Locacion turismo = new Locacion ("Turismo");
        listaDeLocaciones = new ArrayList<Locacion>();
        listaDeLocaciones.add(baños);
        listaDeLocaciones.add(paco);
        listaDeLocaciones.add(mall);
        listaDeLocaciones.add(elevacion);
        listaDeLocaciones.add(comodities);
        listaDeLocaciones.add(ambiente);
        listaDeLocaciones.add(señaletica);
        listaDeLocaciones.add(sustentabilidad);
        listaDeLocaciones.add(seguridad);
        listaDeLocaciones.add(promo);
        listaDeLocaciones.add(turismo);
    }
}
