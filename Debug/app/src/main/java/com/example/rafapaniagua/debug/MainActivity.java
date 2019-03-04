package com.example.rafapaniagua.debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private int numero_1;
    private int numero_2;
    private int resultado;*/

    private int posiciones, aleatorio;
    private List<Integer> numeros;
    private double promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*numero_1 = 10;
        numero_2 = 4;
        resultado = numero_1 + numero_2;*/

        numeros = new ArrayList<Integer>();

        posiciones = (int)(Math.random() * 20) + 1;

        for(int i = 0; i < posiciones; i++){
            aleatorio = (int)(Math.random() * 20) + 1;
            numeros.add( aleatorio);
        }

        for(int i = 0; i < posiciones; i++){
            promedio = promedio + numeros.get(i);
        }

        promedio = promedio/numeros.size();
    }
}
