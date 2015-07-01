package com.example.android.shopping.Entidades;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Seba on 30/06/2015.
 */
public class Recorrida {

    private ArrayList<String> recorrida;

    public Recorrida(ResultSet resultSet) {

        recorrida = new ArrayList<String>();
        recorrida = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Locacion l = new Locacion(descr);
                recorrida.add(l.getDescripcion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





/*
        // Malls------------------------------------------------------------------------------------
        Locacion mall1 = new Locacion ("Mall Acceso Corrientes");
        Locacion mall2 = new Locacion ("Mall Acceso Anchorena");
        Locacion mall3 = new Locacion ("Mall Acceso Agüero");
        Locacion mall4 = new Locacion ("Mall Acceso Anchorena 1°");
        Locacion mall5 = new Locacion ("Mall Acceso Agüero 1°");

        recorrida.add(mall1.getDescripcion());
        recorrida.add(mall2.getDescripcion());
        recorrida.add(mall3.getDescripcion());
        recorrida.add(mall4.getDescripcion());
        recorrida.add(mall5.getDescripcion());


        // Estacionamientos-------------------------------------------------------------------------
        Locacion estacionamiento1 = new Locacion ("Acceso  Estacionamiento 0 Anchorena");
        Locacion estacionamiento2 = new Locacion ("Acceso  Estacionamiento-1 Anchorena");
        Locacion estacionamiento3 = new Locacion ("Acceso Estacionamiento-2 Anchorena");
        Locacion estacionamiento4 = new Locacion ("Acceso  Estacionamiento 0 Agüero");
        Locacion estacionamiento5 = new Locacion ("Acceso  Estacionamiento-1 Agüero");
        Locacion estacionamiento6 = new Locacion ("Acceso Estacionamiento-2 Agüero");

        recorrida.add(estacionamiento1.getDescripcion());
        recorrida.add(estacionamiento2.getDescripcion());
        recorrida.add(estacionamiento3.getDescripcion());
        recorrida.add(estacionamiento4.getDescripcion());
        recorrida.add(estacionamiento5.getDescripcion());
        recorrida.add(estacionamiento6.getDescripcion());

        // Baños------------------------------------------------------------------------------------
        Locacion baño1 = new Locacion("Baños- Nivel 0 (Masc)");
        Locacion baño2 = new Locacion("Baños- nivel 0 (Fem)");
        Locacion baño3 = new Locacion("Baños- nivel 0 (discap)");
        Locacion baño4 = new Locacion("Baños- nivel pb (Masc)");
        Locacion baño5 = new Locacion("Baños- nivel pb (Fem)");
        Locacion baño6 = new Locacion("Baños- nivel pb (discap)");
        Locacion baño7 = new Locacion("Baños- nivel 1° Agüero (masc)");
        Locacion baño8 = new Locacion("Baños- nivel 1° Agüero (fem)");
        Locacion baño9 = new Locacion("Baños- nivel 1° Agüero (discap)");
        Locacion baño10 = new Locacion("Baños- nivel 1° Anchorena (masc)");
        Locacion baño11 = new Locacion("Baños- nivel 1° Anchorena (Fem)");
        Locacion baño12 = new Locacion("Baños- nivel 1° Anchorena (discap)");
        Locacion baño13 = new Locacion("Musimundo (Masc)");
        Locacion baño14 = new Locacion("Musimundo (Fem)");
        Locacion baño15 = new Locacion("Musimundo (discap)");
        Locacion baño16 = new Locacion("Baños- nivel 2° Agüero (masc)");
        Locacion baño17 = new Locacion("Baños- nivel 2° Agüero (Fem)");
        Locacion baño18 = new Locacion("Baños- nivel 2° Agüero( Discap)");
        Locacion baño19 = new Locacion("Baños- nivel 2° Agüero (niños)");
        Locacion baño20 = new Locacion("Baños- nivel 2° Anchorena (masc)");
        Locacion baño21 = new Locacion("Baños- nivel 2° Anchorena (fem)");
        Locacion baño22 = new Locacion("Baños- nivel 2° Anchorena (discap)");
        Locacion baño23 = new Locacion("Baños- nivel 2° Anchorena (Niños)");


        recorrida.add(baño1.getDescripcion());
        recorrida.add(baño2.getDescripcion());
        recorrida.add(baño3.getDescripcion());
        recorrida.add(baño4.getDescripcion());
        recorrida.add(baño5.getDescripcion());
        recorrida.add(baño6.getDescripcion());
        recorrida.add(baño7.getDescripcion());
        recorrida.add(baño8.getDescripcion());
        recorrida.add(baño9.getDescripcion());
        recorrida.add(baño10.getDescripcion());
        recorrida.add(baño11.getDescripcion());
        recorrida.add(baño12.getDescripcion());
        recorrida.add(baño13.getDescripcion());
        recorrida.add(baño14.getDescripcion());
        recorrida.add(baño15.getDescripcion());
        recorrida.add(baño16.getDescripcion());
        recorrida.add(baño17.getDescripcion());
        recorrida.add(baño18.getDescripcion());
        recorrida.add(baño19.getDescripcion());
        recorrida.add(baño20.getDescripcion());
        recorrida.add(baño21.getDescripcion());
        recorrida.add(baño22.getDescripcion());
        recorrida.add(baño23.getDescripcion());

        // Ascensores
        Locacion ascensor1 = new Locacion("Ascensor- Corrientes panorámico");
        Locacion ascensor2 = new Locacion("Ascensor- Administración Anchorena");
        Locacion ascensor3 = new Locacion("Ascensor- administración Agüero");
        Locacion ascensor4 = new Locacion("Ascensor- Adidas/Cope");

        recorrida.add(ascensor1.getDescripcion());
        recorrida.add(ascensor2.getDescripcion());
        recorrida.add(ascensor3.getDescripcion());
        recorrida.add(ascensor4.getDescripcion());

        // Escaleras mecánicas----------------------------------------------------------------------
        Locacion escaleram1 = new Locacion("Esc. Mec.- De SS a Pb Corrientes");
        Locacion escaleram2 = new Locacion("Esc. Mec.- De Pb a SS Corrientes");
        Locacion escaleram3 = new Locacion("Esc. Mec.- De Pb a 1° Corrientes");
        Locacion escaleram4 = new Locacion("Esc. Mec.- De 1° a Pb Corrientes");
        Locacion escaleram5 = new Locacion("Esc. Mec.- De 1° a 2° Corrientes");
        Locacion escaleram6 = new Locacion("Esc. Mec.- De 2° a 1° Corrientes");
        Locacion escaleram7 = new Locacion("Esc. Mec.- Auditorio Museo ascendente");
        Locacion escaleram8 = new Locacion("Esc. Mec.- Auditorio museo descendente");
        Locacion escaleram9 = new Locacion("Esc. Mec.- De SS a Pb Lavalle");
        Locacion escaleram10 = new Locacion("Esc. Mec.- De Pb a SS Lavalle");
        Locacion escaleram11 = new Locacion("Esc. Mec.- De Pb a 1° Lavalle");
        Locacion escaleram12 = new Locacion("Esc. Mec.- De 1° a Pb Lavalle");
        Locacion escaleram13 = new Locacion("Esc. Mec.- De 1° a 2° Agüero");
        Locacion escaleram14 = new Locacion("Esc. Mec.- De 2° a 1° Anchorena");
        Locacion escaleram15 = new Locacion("Esc. Mecánica Cope de -1 a SS Anchorena");
        Locacion escaleram16 = new Locacion("Esc. Mecánica Cope de -2 a -1 Anchorena");
        Locacion escaleram17 = new Locacion("Esc. Mecánica Cope de -1 a SS Agüero");
        Locacion escaleram18 = new Locacion("Esc. Mecánica Cope de -2 a -1 Agüero");

        recorrida.add(escaleram1.getDescripcion());
        recorrida.add(escaleram2.getDescripcion());
        recorrida.add(escaleram3.getDescripcion());
        recorrida.add(escaleram4.getDescripcion());
        recorrida.add(escaleram5.getDescripcion());
        recorrida.add(escaleram6.getDescripcion());
        recorrida.add(escaleram7.getDescripcion());
        recorrida.add(escaleram8.getDescripcion());
        recorrida.add(escaleram9.getDescripcion());
        recorrida.add(escaleram10.getDescripcion());
        recorrida.add(escaleram11.getDescripcion());
        recorrida.add(escaleram12.getDescripcion());
        recorrida.add(escaleram13.getDescripcion());
        recorrida.add(escaleram14.getDescripcion());
        recorrida.add(escaleram15.getDescripcion());
        recorrida.add(escaleram16.getDescripcion());
        recorrida.add(escaleram17.getDescripcion());
        recorrida.add(escaleram18.getDescripcion());
    }
}
*/
