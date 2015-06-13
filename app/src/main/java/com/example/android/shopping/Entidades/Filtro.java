package com.example.android.shopping.Entidades;

/**
 * Created by Seba on 12/06/2015.
 */
public class Filtro {

    private String descripcion;

    public void setDescripcion(String filtro){this.setDescripcion(filtro);}
    public String getDescripcion(){ return descripcion; }

    public Filtro(String descripcion){
        this.setDescripcion(descripcion);
    }
}
