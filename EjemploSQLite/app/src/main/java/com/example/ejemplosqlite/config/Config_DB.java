package com.example.ejemplosqlite.config;

public class Config_DB {
    public static final String name_db = "Libros";
    public static final int version_bd = 1;

    public static final String[] script_db =  {
            "create table categoria(id_categoria int primary key AUTOINCREMENT,nombre_categoria varchar);",
            "create table proveedor(id_proveedor int primary key,nombre_contacto_proveedor varchar,nombre_empresa varchar);",
            "create table producto(id_producto int primary key,nombre_producto varchar,cantidad int," +
                    "fk_proveedor int,fk_categoria int,precio decimal," +
                    "FOREIGN KEY(fk_proveedor) REFERENCES proveedor(id_proveedor)," +
                    "FOREIGN KEY(fk_categoria) REFERENCES categoria(id_categoria));"
    };

}

