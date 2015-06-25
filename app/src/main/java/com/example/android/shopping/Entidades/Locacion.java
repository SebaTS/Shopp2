package com.example.android.shopping.Entidades;

/**
 * Created by android on 04/06/2015.
 */
public class Locacion {

private String descripcion;

    public void setDescripcion(String locacion) {
        this.descripcion = locacion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public Locacion(String locacion){
        this.setDescripcion(locacion);
    }
}
