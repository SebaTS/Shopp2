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
        db.execSQL("CREATE TABLE Usuarios(\n" +
                "id int IDENTITY (1,1),\n" +
                "Usuario char (20) NOT NULL,\n" +
                "Contraseña char (20) NOT NULL,\n" +
                "Nombre char (50))");
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

    public void verificar(String Prueba){
        SQLiteDatabase db = getReadableDatabase();
        Prueba = db.execSQL("Select Usuario, Contraseña FROM Usuarios WHERE Usuario = "++" AND Cotnraseña = "+);
        if (Prueba = "") {
            Message ()
        }
        db.close();
    }



}
