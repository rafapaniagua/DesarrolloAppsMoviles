package com.example.appempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_listado;
    private EditText et_buscar;
    private ArrayList <Empleado> arregloEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_listado = (TextView) findViewById(R.id.tv_listado);
        et_buscar = (EditText) findViewById(R.id.et_buscar);
        arregloEmpleado = new ArrayList<Empleado>();

        if(getIntent().hasExtra("arreglo")){
            arregloEmpleado = (ArrayList<Empleado>) getIntent().getExtras().getSerializable("arreglo");
        }

        this.verEmpleados();
    }

    public void registrar(View v){
        //Creamos el nuevo activity y cerramosel actual, ademas enviamos el arreglo completo
        Intent intent = new Intent(this, Registro.class);
        intent.putExtra("arreglo", this.arregloEmpleado);
        startActivity(intent);
        finish();
    }

    private void verEmpleados(){
        if(this.arregloEmpleado.isEmpty()){
            tv_listado.setText("Los siento, Actualmente no hay datos disponibles");
        }else{
            String cadena = "";
            for (Empleado emp_tem : this.arregloEmpleado){
                cadena += emp_tem.getNombre() + " " + emp_tem.getApellidoP() + " " + emp_tem.getApellidoM() + "\n" +
                        emp_tem.getArea() + "\n---------------------------------\n";
            }
            tv_listado.setText(cadena);
        }
    }

    public void buscar(View v){
        if(this.arregloEmpleado.isEmpty()){
            Toast.makeText(this, "No hay elementos en la lista", Toast.LENGTH_LONG).show();
        } else {
            if(!et_buscar.getText().toString().equals("")){
                String busqueda = et_buscar.getText().toString();
                String encontrados = "";
                String temp = "";

                for(Empleado emp_tem : this.arregloEmpleado){
                    temp = emp_tem.getNombre() + " " + emp_tem.getApellidoP() + " " + emp_tem.getApellidoM() + "\n" +
                            emp_tem.getArea() + "\n---------------------------------\n";
                    //temp.contains(busqueda)
                    if(temp.contains(busqueda)){
                        encontrados += temp;
                    }
                    temp = "";
                }

                if (encontrados.equals("")){
                    Toast.makeText(this, "No se encontró ninguna coincidencia", Toast.LENGTH_LONG).show();
                    this.verEmpleados();
                }else{
                    tv_listado.setText(encontrados);
                }
            }else{
                Toast.makeText(this, "Introduce algún criterio de búsqueda", Toast.LENGTH_LONG).show();
                this.verEmpleados();
            }
        }
    }
}
