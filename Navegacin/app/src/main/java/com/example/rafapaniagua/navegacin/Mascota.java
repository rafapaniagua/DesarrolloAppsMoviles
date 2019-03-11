package com.example.rafapaniagua.navegacin;

import java.io.Serializable;

public class Mascota implements Serializable {
    String nombre;
    String raza;
    int edad;

    public Mascota(String nombre, String raza, int edad){
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }
}
