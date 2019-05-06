package com.example.ejemplosqlite.base_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ejemplosqlite.config.Config_DB;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase base_datos) {
        // PARA HACERLO INDIVIDUALMENTE A UNA SOLA TABLA

        /*String table_autor = "CREATE TABLE autor( " +
                "pk_autor INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre varchar(100) not null, " +
                "primer_apellido varchar(100) not null, " +
                "segundo_apellido varchar(100) not null, " +
                "FOREIGN KEY(pk_autor) REFERENCES autor(pk_autor)" +
                ");";*/

        //base_datos.execSQL(table_autor);

        // PARA EJECUTAR CADA UNA DE LAS INSTRUCCIONES

        for (String query : Config_DB.script_db){
            base_datos.execSQL(query);
        }
    }
}
