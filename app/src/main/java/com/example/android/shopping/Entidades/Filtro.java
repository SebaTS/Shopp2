package com.example.android.shopping.Entidades;

/**
 * Created by Seba on 12/06/2015.
 */
public class Filtro {

    private String filtro;

    public void setfiltro(String descripcion){this.filtro = descripcion;}
    public String getfiltro(){ return filtro; }

    public Filtro(String descripcion){
        this.setfiltro(descripcion);
    }
}
