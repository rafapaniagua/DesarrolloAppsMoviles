package com.example.appempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    private EditText et_nombre, et_apellidoP, et_apellidoM, et_area;
    private Empleado empleado;
    private ArrayList <Empleado> arregloEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_apellidoP = (EditText) findViewById(R.id.et_apellidoP);
        et_apellidoM = (EditText) findViewById(R.id.et_apellidoM);
        et_area = (EditText) findViewById(R.id.et_area);

        arregloEmpleado = new ArrayList<Empleado>();

        if(getIntent().hasExtra("arreglo")){
            arregloEmpleado = (ArrayList<Empleado>) getIntent().getExtras().getSerializable("arreglo");
        }

    }

    public void guardar(View v){

        if (!et_nombre.getText().toString().equals("") &&
                !et_apellidoP.getText().toString().equals("") &&
                !et_apellidoM.getText().toString().equals("") &&
                !et_area.getText().toString().equals("")){

            empleado = new Empleado(); //Creamos un nuevo empleado

            //Asiganmos los datos registrados
            empleado.setNombre(et_nombre.getText().toString());
            empleado.setApellidoP(et_apellidoP.getText().toString());
            empleado.setApellidoM(et_apellidoM.getText().toString());
            empleado.setArea(et_area.getText().toString());

            //Agregamos el nuevo empleado al arreglo
            arregloEmpleado.add(empleado);

            //Enviamos el arreglo al activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("arreglo", arregloEmpleado);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Por favor completa todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View v){
        //Enviamos el arreglo al activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("arreglo", arregloEmpleado);
        startActivity(intent);
        finish();
    }
}
