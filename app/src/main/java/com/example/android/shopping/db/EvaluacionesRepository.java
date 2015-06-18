package com.example.android.shopping.db;

import com.example.android.shopping.Entidades.Evaluacion;

import java.util.ArrayList;

/**
 * Created by Seba on 16/06/2015.
 */
public class EvaluacionesRepository {

    public ArrayList<String> listaDeEvaluaciones;

    public EvaluacionesRepository(){
        listaDeEvaluaciones = new ArrayList<String>();

        Evaluacion noevaluado = new Evaluacion("No evaluado");
        Evaluacion malo = new Evaluacion("Malo");
        Evaluacion medio = new Evaluacion("Medio");
        Evaluacion bueno = new Evaluacion("Bueno");

        listaDeEvaluaciones.add(noevaluado.getestado());
        listaDeEvaluaciones.add(malo.getestado());
        listaDeEvaluaciones.add(medio.getestado());
        listaDeEvaluaciones.add(bueno.getestado());
    }


}
