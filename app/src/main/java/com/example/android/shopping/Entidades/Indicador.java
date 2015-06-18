package com.example.android.shopping.Entidades;

/**
 * Created by android on 04/06/2015.
 */
public class Indicador {

    private String lugar;
    private String descr;

    public void setdescr(String indicador) {
        this.descr = indicador;
    }
    public void setLugar(String locacion) { this.lugar = locacion; }
    public String getdescr() {
        return descr;
    }
    public String getLugar() { return lugar; }

    public Indicador (String locacion, String indicador){
        this.setdescr(indicador);
        this.setLugar(locacion);
    }
}

