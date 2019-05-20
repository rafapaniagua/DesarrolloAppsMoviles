package com.example.ejemplosqlite.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejemplosqlite.base_datos.BaseDatos;
import com.example.ejemplosqlite.config.Config_DB;

public class Categoria {
    private int id_categoria;
    private String nombre_categoria;
    private BaseDatos admin;
    private SQLiteDatabase base_datos;
    public Categoria(){
        this.id_categoria = 0;
        this.nombre_categoria = "";
    }

    public Categoria(int id_categoria, String nombre_categoria, BaseDatos admin, SQLiteDatabase base_datos) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.admin = admin;
        this.base_datos = base_datos;
    }

    private void inicializate_db(Context context){
        admin = new BaseDatos(
                context,
                Config_DB.name_db,
                null,
                Config_DB.version_bd);
        base_datos = admin.getWritableDatabase();
    }
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public boolean save(Context context){
        this.inicializate_db(context);
        ContentValues valores_objeto = new ContentValues();
        if(this.id_categoria == 0){
            //registrar
            valores_objeto.put("nombre_categoria",this.nombre_categoria);
            base_datos.insert("categoria",null,valores_objeto);
            base_datos.close();
            return true;
        }else{
            //actualizar
            valores_objeto.put("nombre_categoria",this.nombre_categoria);
            int actualizado = base_datos.update(
                    "categoria",
                    valores_objeto,
                    "id_categoria=" + this.id_categoria,
                    null );
            base_datos.close();
            if(actualizado == 1)
                return true;
        }
        return false;
    }

    public void get(Context context, int id_categoria){
        this.inicializate_db(context);
        String query = "select * from categoria where id_categoria = " + id_categoria;
        //leer de BD
        Cursor registro = base_datos.rawQuery(query,null);
        if(registro.moveToFirst()){
            this.id_categoria     = registro.getInt(0);
            this.nombre_categoria = registro.getString(1);
        }
        base_datos.close();

    }
    public void delete(Context context){
        this.inicializate_db(context);
        //eliminar
        int eliminado = base_datos.delete("categoria","id_categoria=" + this.id_categoria,null);
        base_datos.close();
        if(eliminado ==1){
            this.id_categoria = 0;
            this.nombre_categoria = "";
        }
    }
}
