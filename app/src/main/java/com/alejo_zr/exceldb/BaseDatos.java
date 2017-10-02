package com.alejo_zr.exceldb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alejo_zr.exceldb.utilidades.Utilidades;

/**
 * Created by Alejo on 26/09/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;

    // Nombre de nuestro archivo de base de datos
    private static final String NOMBRE_BASEDATOS = "basedatos.db";




    // CONSTRUCTOR de la clase
    public BaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_CARRETERA);
        db.execSQL(Utilidades.CREAR_TABLA_SEGMENTO);
        db.execSQL(Utilidades.CREAR_TABLA_PATOLOGIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_CARRETERA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SEGMENTO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PATOLOGIA);
        onCreate(db);
    }

    public Cursor getroad() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + Utilidades.TABLA_CARRETERA + " ",
                null);
        return res;
    }

    public Cursor getSegmento() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + Utilidades.TABLA_SEGMENTO + " ",
                null);
        return res;
    }

    public Cursor getPato() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + Utilidades.TABLA_PATOLOGIA + " ",
                null);
        return res;
    }


}