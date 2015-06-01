package com.example.android.shopping;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Seba on 30/05/2015.
 */
public class Usuarios extends SQLiteOpenHelper {

    public Usuarios(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("CREATE TABLE Usuarios(id int IDENTITY (1,1), Usuario char (20) NOT NULL, Contraseña char (20) NOT NULL, Nombre char (50))");
        db.close();
    }

    public void RegistroEjemplo (){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Usuarios (Usuario, Contraseña, Nombre) VALUES ('BTV', 'BTV', 'Lospi')");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean verificar(String User, String Pass){
        String Prueba;
        SQLiteDatabase db = getReadableDatabase();
        Prueba = db.execSQL("Select Usuario, Contraseña FROM Usuarios WHERE Usuario = " + User + " AND Contraseña = " + Pass);
        if (Prueba = "") {
            return false;
        }
        else{
            return true;
        }
        db.close();
    }
}
