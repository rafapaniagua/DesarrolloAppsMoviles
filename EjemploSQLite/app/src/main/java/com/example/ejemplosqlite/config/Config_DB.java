package com.example.ejemplosqlite.config;

public class Config_DB {

    public static final String name_bd = "Libros";
    public static final int version_bd = 1;

    public static final String [] script_db = {
            "create table proveedor(id_proveedor INT primary key," +
                    "nombre_proveedor TEXT," +
                    "empresa TEXT);",
            "create table categoria(id_categoria INT primary key," +
                    "nombre_categoria TEXT);",
            "create table producto(id_producto INT primary key," +
                    "nombre_producto TEXT," +
                    "cantidad INT," +
                    "precio DECIMAL," +
                    "fk_proveedor INT," +
                    "fk_categoria INT," +
                    "FOREIGN KEY (fk_proveedor) REFERENCES proveedor (id_proveedor)," +
                    "FOREIGN KEY (fk_categoria) REFERENCES categoria (id_categoria));"
    };

}
