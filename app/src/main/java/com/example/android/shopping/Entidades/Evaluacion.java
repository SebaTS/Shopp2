package com.example.android.shopping.Entidades;

/**
 * Created by Seba on 16/06/2015.
 */
public class Evaluacion {

    private String estado;

    public void setestado(String descripcion){this.estado = descripcion;}
    public String getestado(){ return estado; }

    public Evaluacion(String descripcion){
        this.setestado(descripcion);
    }
}
