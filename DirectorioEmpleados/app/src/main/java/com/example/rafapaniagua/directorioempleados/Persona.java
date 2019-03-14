package com.example.rafapaniagua.directorioempleados;

public class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int noNomina;
    private int telefono;
    private String area;

    public Persona() {

    }

    public Persona(String nombre, String apellidoP, String apellidoM, int noNomina, int telefono, String area) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.noNomina = noNomina;
        this.telefono = telefono;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getNoNomina() {
        return noNomina;
    }

    public void setNoNomina(int noNomina) {
        this.noNomina = noNomina;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
