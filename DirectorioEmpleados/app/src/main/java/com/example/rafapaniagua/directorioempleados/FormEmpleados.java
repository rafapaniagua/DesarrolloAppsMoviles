package com.example.rafapaniagua.directorioempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FormEmpleados extends AppCompatActivity {

    private ArrayList<Persona> lista_personas;
    private EditText edt_nombre;
    private EditText edt_apellidoP;
    private EditText edt_apellidoM;
    private EditText edt_noNomina;
    private EditText edt_telefono;
    private EditText edt_area;
    private Button btn_registrar;
    private Button btn_cancelar;

    private Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_empleados);

        this.edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        this.edt_apellidoP = (EditText) findViewById(R.id.edt_apellidoP);
        this.edt_apellidoM = (EditText) findViewById(R.id.edt_apellidoM);
        this.edt_noNomina = (EditText) findViewById(R.id.edt_noNomina);
        this.edt_telefono = (EditText) findViewById(R.id.edt_telefono);
        this.edt_area = (EditText) findViewById(R.id.edt_area);
        this.btn_registrar = (Button) findViewById(R.id.btn_registrar);
        this.btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        lista_personas = new ArrayList<Persona>();

        if(getIntent().hasExtra("lista_personas")){
            this.lista_personas = (ArrayList<Persona>) getIntent().getExtras().getSerializable("lista_personas");
        }
    }

    public void guardar(View view){
        if(!this.validar_vacios()){
            Toast.makeText(this,"Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }else{
            lista_personas.add(new Persona(edt_nombre.getText().toString().trim(),
                                            edt_apellidoP.getText().toString().trim(),
                                            edt_apellidoM.getText().toString().trim(),
                                            Integer.parseInt(edt_noNomina.getText().toString().trim()),
                                            Integer.parseInt(edt_telefono.getText().toString().trim()),
                                            edt_area.getText().toString().trim()));

            main.putExtra("lista_personas", this.lista_personas);
            startActivity(main);
        }
    }

    public void cancelar(View view) {
        main.putExtra("lista_personas", this.lista_personas);
        startActivity(main);
    }

    public boolean validar_vacios(){
        return (edt_nombre.getText().toString().trim().length() > 0
                && edt_apellidoP.getText().toString().trim().length() > 0
                && edt_apellidoM.getText().toString().trim().length() > 0
                && edt_noNomina.getText().toString().trim().length() > 0
                && edt_telefono.getText().toString().trim().length() > 0
                && edt_area.getText().toString().trim().length() > 0);
    }
}
