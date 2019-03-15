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

        if(getIntent().hasExtra("lista")){
            this.lista_personas = (ArrayList<Persona>) getIntent().getExtras().getSerializable("lista_personas");
        }
    }

    public void guardar(View view){
        if(this.validar_vacios()){
            Toast.makeText(this,"Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }else{
            lista_personas.add(new Persona(edt_nombre.getText().toString(),
                                            edt_apellidoP.getText().toString(),
                                            edt_apellidoM.getText().toString(),
                                            edt_area.getText().toString()));

            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("lista", this.lista_personas);
            startActivity(main);
            finish();
        }
    }

    public void cancelar(View view) {
        Intent main = new Intent(this, MainActivity.class);
        main.putExtra("lista", this.lista_personas);
        startActivity(main);
        finish();
    }

    public boolean validar_vacios(){
        return (edt_nombre.getText().toString().equals("")
                || edt_apellidoP.getText().toString().equals("")
                || edt_apellidoM.getText().toString().equals("")
                || edt_area.getText().toString().equals(""));
    }
}
