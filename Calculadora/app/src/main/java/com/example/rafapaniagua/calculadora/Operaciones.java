package com.example.rafapaniagua.calculadora;

public class Operaciones {
    public boolean validarRango(int numero, int limiteInferior, int limiteSuperior){
        return numero>=limiteInferior && numero<=limiteSuperior;
    }

    public String [] separarCadena(String cadena) {
        String[] mascara = cadena.split("/");
        String[] octetos = mascara[0].split("[.]");
        String[] datos = new String[5];
        System.arraycopy(octetos, 0, datos, 0, 4);
        datos[4] = mascara[1];
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
        return octetos;
    }

    public int convertirANumero(String cadena){
        return 5;
    }
}