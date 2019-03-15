package com.example.rafapaniagua.directorioempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> lista_personas;
    private EditText edt_busqueda;
    private TextView txt_personas;
    private Button btn_buscar;
    private Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edt_busqueda = (EditText) findViewById(R.id.edt_busqueda);
        this.txt_personas = (TextView) findViewById(R.id.txt_personas);
        this.btn_buscar = (Button) findViewById(R.id.btn_buscar);
        this.btn_agregar = (Button) findViewById(R.id.btn_agregar);
        lista_personas = new ArrayList<Persona>();

        if(getIntent().hasExtra("lista")){
            this.lista_personas = (ArrayList<Persona>) getIntent().getExtras().getSerializable("lista_personas");
        }

        this.muestraPersonas();
    }

    public void agregar(View view){
        Intent formulario = new Intent(this, FormEmpleados.class);
        formulario.putExtra("lista",this.lista_personas);
        startActivity(formulario);
        finish();
    }

    public void buscar(View view){
        if(this.lista_personas.isEmpty()){
            Toast.makeText(this, "No hay elementos en la lista", Toast.LENGTH_LONG).show();
        } else {
            String encontrados = this.filtrar_personas();
            if(encontrados.length() > 0){
                txt_personas.setText(encontrados);
            } else {
                Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show();
                this.muestraPersonas();
            }
        }
    }

    private String filtrar_personas(){
        String busqueda = edt_busqueda.getText().toString();
        String coincidencias = "";
        String temp = "";

        for(Persona persona_temp : this.lista_personas){
            temp = persona_temp.getNombre() + " " + persona_temp.getApellidoP() + " " + persona_temp.getApellidoM() + "\n" +
                    " - " + persona_temp.getArea() + "\n____________________\n";
            if(temp.contains(busqueda)){
                coincidencias += temp;
            }
            temp = "";
        }

        return coincidencias;
    }

    private void muestraPersonas(){
        if(this.lista_personas.isEmpty()){
            txt_personas.setText("No hay personas registradas");
        }else{
            String lista = "";
            for (Persona persona_temp : this.lista_personas){
                lista += persona_temp.getNombre() + " " + persona_temp.getApellidoP() + " " + persona_temp.getApellidoM() + "\n" +
                        " - " + persona_temp.getArea() + "\n____________________\n";
            }
            txt_personas.setText(lista);
        }
    }
}
