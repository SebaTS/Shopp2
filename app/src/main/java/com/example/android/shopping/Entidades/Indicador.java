package com.example.android.shopping.Entidades;

/**
 * Created by android on 04/06/2015.
 */
public class Indicador {

    private String descr;

    public void setdescr(String indicador) {
        this.descr = indicador;
    }
    public String getdescr() {
        return descr;
    }

    public Indicador (String indicador){
        this.setdescr(indicador);
    }
}

}
