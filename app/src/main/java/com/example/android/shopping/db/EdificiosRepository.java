package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Edificio;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by android on 25/06/2015.
 */
public class EdificiosRepository {

    public ArrayList<String> listaDeEdificios;

    // Llena al array con los edificios.
    public EdificiosRepository(ResultSet resultSet) {

        listaDeEdificios = new ArrayList<String>();
        listaDeEdificios = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Edificio e = new Edificio(descr);
                listaDeEdificios.add(e.getedificio());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




/*        Edificio abasto = new Edificio("Abasto");
        Edificio altoavellaneda = new Edificio("Alto Avellaneda");
        Edificio altopalermo = new Edificio("Alto Palermo");
        Edificio bsasdesign = new Edificio("Bs As Design");
        Edificio cordoba = new Edificio("Cordoba Shopping");
        Edificio dot = new Edificio("Dot Baires");
        Edificio mzaplaza = new Edificio("Mza Plaza");
        Edificio alcorta = new Edificio("Alcorta Shopping");
        Edificio patiobullrich = new Edificio("Patio Bullrich");

        listaDeEdificios.add(abasto);
        listaDeEdificios.add(altoavellaneda);
        listaDeEdificios.add(altopalermo);
        listaDeEdificios.add(bsasdesign);
        listaDeEdificios.add(cordoba);
        listaDeEdificios.add(dot);
        listaDeEdificios.add(mzaplaza);
        listaDeEdificios.add(alcorta);
        listaDeEdificios.add(patiobullrich);
    }

}*/
