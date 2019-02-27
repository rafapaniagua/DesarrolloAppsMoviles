package com.example.rafapaniagua.ejemplo25feb2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inp_numero;
    private Button   btn_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculando input
        inp_numero = (EditText) findViewById(R.id.inp_numero);
        //fijar texto
        inp_numero.setText("123456");
    }

    //Se recibe View, para poder manejar layout
    public void boton_presionado(View view) {
        //leyendo contenido de input
        String texto = inp_numero.getText().toString();

        //desplegar mensaje emergente en pantalla
        Toast toast = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG);
        toast.show();
    }
}