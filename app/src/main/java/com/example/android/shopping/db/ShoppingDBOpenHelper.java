package com.example.android.shopping.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 23/06/2015.
 */
public class ShoppingDBOpenHelper extends SQLiteOpenHelper {

    private final String SHOPPING_DB_NAME = "Shopping";

    public final String TABLA_USUARIOS_NOMBRE = "Usuarios";
    public final String TABLA_USUARIOS_COLUMNA_USUARIO = "Usuario";
    public final String TABLA_USUARIOS_COLUMNA_CONTRASEÑA = "Contraseña";

    private final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS Usuarios(" +
            "    id MEDIUMINT NOT NULL," +
            "    Usuario char (20) NOT NULL," +
            "    Contraseña char (20) NOT NULL," +
            "    Nombre char (50)," +
            "    PRIMARY KEY (id))";

    public ShoppingDBOpenHelper(Context context) {
        super(context, "Shopping", null, 1);
    }

    public boolean existeUsuario(String whereColumns, String[] whereValues, String limit) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                TABLA_USUARIOS_COLUMNA_USUARIO,
                TABLA_USUARIOS_COLUMNA_CONTRASEÑA
        };

        String sortOrder = TABLA_USUARIOS_COLUMNA_USUARIO + " ASC";

        try {
            Cursor cursor = db.query
                    (
                            TABLA_USUARIOS_NOMBRE,
                            projection,
                            whereColumns,
                            whereValues,
                            null,
                            null,
                            sortOrder,
                            limit
                    );

            boolean resultado = cursor.moveToFirst();

            cursor.close();

            db.close();

            return resultado;

        } catch (Exception e) {
            int a = 0;
        }

        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(CREATE_TABLE_SQL);

            ContentValues valores = new ContentValues();
            valores.put(TABLA_USUARIOS_COLUMNA_USUARIO, "prueba");
            valores.put(TABLA_USUARIOS_COLUMNA_CONTRASEÑA, "prueba");

            db.insert(TABLA_USUARIOS_NOMBRE, null, valores);

        } catch (Exception x) {
            int a = 0;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
