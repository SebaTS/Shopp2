package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Edificio;

import java.util.ArrayList;

/**
 * Created by android on 25/06/2015.
 */
public class EdificiosRepository {

    public ArrayList<String> listaDeEdificios;

    // Llena al array con los edificios.
    public EdificiosRepository() {

        listaDeEdificios = new ArrayList<String>();

        Edificio abasto = new Edificio("Abasto");
        Edificio altoavellaneda = new Edificio("Alto Avellaneda");
        Edificio altopalermo = new Edificio("Alto Palermo");
        Edificio bsasdesign = new Edificio("Bs As Design");
        Edificio cordoba = new Edificio("Cordoba Shopping");
        Edificio dot = new Edificio("Dot Baires");
        Edificio mzaplaza = new Edificio("Mza Plaza");
        Edificio alcorta = new Edificio("Alcorta Shopping");
        Edificio patiobullrich = new Edificio("Patio Bullrich");

        listaDeEdificios.add(abasto.getedificio());
        listaDeEdificios.add(altoavellaneda.getedificio());
        listaDeEdificios.add(altopalermo.getedificio());
        listaDeEdificios.add(bsasdesign.getedificio());
        listaDeEdificios.add(cordoba.getedificio());
        listaDeEdificios.add(dot.getedificio());
        listaDeEdificios.add(mzaplaza.getedificio());
        listaDeEdificios.add(alcorta.getedificio());
        listaDeEdificios.add(patiobullrich.getedificio());
    }

}
