package com.example.android.shopping.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.android.shopping.Entidades.Locacion;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by android on 04/06/2015.
 */
public class LocacionesRepository {

    public ArrayList<String> listaDeLocaciones;
//    public ArrayList<String> listaDeLocacionesMall;
//    public ArrayList<String> listaDeLocacionesEstacionamientos;
//    public ArrayList<String> listaDeLocacionesBaños;
//    public ArrayList<String> listaDeLocacionesAscensores;
//    public ArrayList<String> listaDeLocacionesEscalerasM;

    // Llena al array con las locaciones.
    public LocacionesRepository(ResultSet resultSet) {

        listaDeLocaciones = new ArrayList<String>();
        listaDeLocaciones = null;
        try {
            while (resultSet.next()) {
                String descr = resultSet.getString("Descripcion");
                Locacion l = new Locacion(descr);
                listaDeLocaciones.add(l.getDescripcion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*
        listaDeLocaciones = new ArrayList<String>();
        listaDeLocacionesMall = new ArrayList<String>();
        listaDeLocacionesEstacionamientos = new ArrayList<String>();
        listaDeLocacionesBaños = new ArrayList<String>();
        listaDeLocacionesAscensores = new ArrayList<String>();
        listaDeLocacionesEscalerasM = new ArrayList<String>();

        // Malls------------------------------------------------------------------------------------
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

        // Estacionamientos-------------------------------------------------------------------------
        Locacion estacionamiento1 = new Locacion ("Acceso  Estacionamiento 0 Anchorena");
        Locacion estacionamiento2 = new Locacion ("Acceso  Estacionamiento-1 Anchorena");
        Locacion estacionamiento3 = new Locacion ("Acceso Estacionamiento-2 Anchorena");
        Locacion estacionamiento4 = new Locacion ("Acceso  Estacionamiento 0 Agüero");
        Locacion estacionamiento5 = new Locacion ("Acceso  Estacionamiento-1 Agüero");
        Locacion estacionamiento6 = new Locacion ("Acceso Estacionamiento-2 Agüero");

        listaDeLocaciones.add(estacionamiento1.getDescripcion());
        listaDeLocaciones.add(estacionamiento2.getDescripcion());
        listaDeLocaciones.add(estacionamiento3.getDescripcion());
        listaDeLocaciones.add(estacionamiento4.getDescripcion());
        listaDeLocaciones.add(estacionamiento5.getDescripcion());
        listaDeLocaciones.add(estacionamiento6.getDescripcion());

        listaDeLocacionesEstacionamientos.add(estacionamiento1.getDescripcion());
        listaDeLocacionesEstacionamientos.add(estacionamiento2.getDescripcion());
        listaDeLocacionesEstacionamientos.add(estacionamiento3.getDescripcion());
        listaDeLocacionesEstacionamientos.add(estacionamiento4.getDescripcion());
        listaDeLocacionesEstacionamientos.add(estacionamiento5.getDescripcion());
        listaDeLocacionesEstacionamientos.add(estacionamiento6.getDescripcion());

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


        listaDeLocaciones.add(baño1.getDescripcion());
        listaDeLocaciones.add(baño2.getDescripcion());
        listaDeLocaciones.add(baño3.getDescripcion());
        listaDeLocaciones.add(baño4.getDescripcion());
        listaDeLocaciones.add(baño5.getDescripcion());
        listaDeLocaciones.add(baño6.getDescripcion());
        listaDeLocaciones.add(baño7.getDescripcion());
        listaDeLocaciones.add(baño8.getDescripcion());
        listaDeLocaciones.add(baño9.getDescripcion());
        listaDeLocaciones.add(baño10.getDescripcion());
        listaDeLocaciones.add(baño11.getDescripcion());
        listaDeLocaciones.add(baño12.getDescripcion());
        listaDeLocaciones.add(baño13.getDescripcion());
        listaDeLocaciones.add(baño14.getDescripcion());
        listaDeLocaciones.add(baño15.getDescripcion());
        listaDeLocaciones.add(baño16.getDescripcion());
        listaDeLocaciones.add(baño17.getDescripcion());
        listaDeLocaciones.add(baño18.getDescripcion());
        listaDeLocaciones.add(baño19.getDescripcion());
        listaDeLocaciones.add(baño20.getDescripcion());
        listaDeLocaciones.add(baño21.getDescripcion());
        listaDeLocaciones.add(baño22.getDescripcion());
        listaDeLocaciones.add(baño23.getDescripcion());

        listaDeLocacionesBaños.add(baño1.getDescripcion());
        listaDeLocacionesBaños.add(baño2.getDescripcion());
        listaDeLocacionesBaños.add(baño3.getDescripcion());
        listaDeLocacionesBaños.add(baño4.getDescripcion());
        listaDeLocacionesBaños.add(baño5.getDescripcion());
        listaDeLocacionesBaños.add(baño6.getDescripcion());
        listaDeLocacionesBaños.add(baño7.getDescripcion());
        listaDeLocacionesBaños.add(baño8.getDescripcion());
        listaDeLocacionesBaños.add(baño9.getDescripcion());
        listaDeLocacionesBaños.add(baño10.getDescripcion());
        listaDeLocacionesBaños.add(baño11.getDescripcion());
        listaDeLocacionesBaños.add(baño12.getDescripcion());
        listaDeLocacionesBaños.add(baño13.getDescripcion());
        listaDeLocacionesBaños.add(baño14.getDescripcion());
        listaDeLocacionesBaños.add(baño15.getDescripcion());
        listaDeLocacionesBaños.add(baño16.getDescripcion());
        listaDeLocacionesBaños.add(baño17.getDescripcion());
        listaDeLocacionesBaños.add(baño18.getDescripcion());
        listaDeLocacionesBaños.add(baño19.getDescripcion());
        listaDeLocacionesBaños.add(baño20.getDescripcion());
        listaDeLocacionesBaños.add(baño21.getDescripcion());
        listaDeLocacionesBaños.add(baño22.getDescripcion());
        listaDeLocacionesBaños.add(baño23.getDescripcion());

        // Ascensores
        Locacion ascensor1 = new Locacion("Ascensor- Corrientes panorámico");
        Locacion ascensor2 = new Locacion("Ascensor- Administración Anchorena");
        Locacion ascensor3 = new Locacion("Ascensor- administración Agüero");
        Locacion ascensor4 = new Locacion("Ascensor- Adidas/Cope");

        listaDeLocaciones.add(ascensor1.getDescripcion());
        listaDeLocaciones.add(ascensor2.getDescripcion());
        listaDeLocaciones.add(ascensor3.getDescripcion());
        listaDeLocaciones.add(ascensor4.getDescripcion());

        listaDeLocacionesAscensores.add(ascensor1.getDescripcion());
        listaDeLocacionesAscensores.add(ascensor2.getDescripcion());
        listaDeLocacionesAscensores.add(ascensor3.getDescripcion());
        listaDeLocacionesAscensores.add(ascensor4.getDescripcion());

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

        listaDeLocaciones.add(escaleram1.getDescripcion());
        listaDeLocaciones.add(escaleram2.getDescripcion());
        listaDeLocaciones.add(escaleram3.getDescripcion());
        listaDeLocaciones.add(escaleram4.getDescripcion());
        listaDeLocaciones.add(escaleram5.getDescripcion());
        listaDeLocaciones.add(escaleram6.getDescripcion());
        listaDeLocaciones.add(escaleram7.getDescripcion());
        listaDeLocaciones.add(escaleram8.getDescripcion());
        listaDeLocaciones.add(escaleram9.getDescripcion());
        listaDeLocaciones.add(escaleram10.getDescripcion());
        listaDeLocaciones.add(escaleram11.getDescripcion());
        listaDeLocaciones.add(escaleram12.getDescripcion());
        listaDeLocaciones.add(escaleram13.getDescripcion());
        listaDeLocaciones.add(escaleram14.getDescripcion());
        listaDeLocaciones.add(escaleram15.getDescripcion());
        listaDeLocaciones.add(escaleram16.getDescripcion());
        listaDeLocaciones.add(escaleram17.getDescripcion());
        listaDeLocaciones.add(escaleram18.getDescripcion());

        listaDeLocacionesEscalerasM.add(escaleram1.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram2.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram3.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram4.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram5.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram6.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram7.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram8.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram9.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram10.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram11.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram12.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram13.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram14.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram15.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram16.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram17.getDescripcion());
        listaDeLocacionesEscalerasM.add(escaleram18.getDescripcion());

    }

    // MÉTODO VIEJO.
    // Limpia el array, llenandolo con las locaciones que cumplan con el filtro.
//    public void MostrarLocaciones(int filtro){
//        listaDeLocaciones.clear();
//        if (filtro == 1){
//            Locacion baños = new Locacion("Baños");
//            listaDeLocaciones.add(baños.getDescripcion());
//        } else if (filtro == 2) {
//            Locacion mall = new Locacion("Mall");
//            listaDeLocaciones.add(mall.getDescripcion());
//        } else if (filtro.equals("Todos")){
//            listaDeLocaciones.add("Todos");
//        }
//    }

    // MÉTODO NUEVO
    // Devuelve el array correspondiente al filtro.
    public ArrayList<String> obtenerLocaciones(int filtro) {
        ArrayList<String> locaciones = null;

        switch (filtro){
            case 0 :
                locaciones = listaDeLocaciones;
                break;
            case 1 :
                locaciones = listaDeLocacionesMall;
                break;
            case 2 :
                locaciones = listaDeLocacionesEstacionamientos;
                break;
            case 3 :
                locaciones = listaDeLocacionesBaños;
                break;
            case 4 :
                locaciones = listaDeLocacionesAscensores;
                break;
            case 5 :
                locaciones = listaDeLocacionesEscalerasM;
            default :
                locaciones = null;
                break;
        }

        return locaciones;
    }

    // Devuelve el array de locaciones.
//    public List<Locacion> obtenerTodasLasCategorias() {        return this.listaDeLocaciones;    }
}*/
