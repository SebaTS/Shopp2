package com.example.android.shopping.Entidades;

/**
 * Created by android on 04/06/2015.
 */
public class Locacion {

    private String descr;

    public void setdescr(String locacion) {
        this.descr = locacion;
    }
    public String getdescr() {
        return descr;
    }

    public Locacion (String locacion){
        this.setdescr(locacion);
    }
}
