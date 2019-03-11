package com.example.rafapaniagua.navegacin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Mascota masc = (Mascota) getIntent()
                .getExtras()
                .getSerializable("pet");

        String mensaje = "Detalles de la mascota\n\n" +
                         "-Nombre: " + masc.nombre + "\n" +
                         "-Raza: " + masc.raza + "\n" +
                         "-Edad: " + masc.edad;

        Toast toast = Toast.makeText(
                getApplicationContext(),
                mensaje,
                Toast.LENGTH_LONG
        );

        toast.show();
    }

    public void activity1(View view){
        Intent intent = new Intent(
                this,
                MainActivity.class
        );

        startActivity(intent);
    }
}
