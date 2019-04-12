package com.example.empleados;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.empleados.adapters.RVEmpleadoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVEmpleadoAdapter adapter;

    private EditText editBuscar;
    private String[] columnas = {
            "nombre",
            "apellidoP",
            "apellidoM",
            "telefono",
            "fechaNac",
            "correo",
            "calleYNo",
            "colonia",
            "ciudad",
            "estado",
            "estadoCivil",
            "enfermedades",
            "nacionalidad",
            "imagen",
            "noNomina",
            "area",
            "puesto",
            "rfc",
            "curp",
            "nss",
            "contactoSOS",
            "escolaridad",
            "status"
    };

    List<Empleado> empleados;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBuscar = (EditText) findViewById(R.id.et_buscar);

        database = openOrCreateDatabase("Directorio", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Empleado(" +
                "nombre VARCHAR," +
                "apellidoP VARCHAR," +
                "apellidoM VARCHAR," +
                "telefono VARCHAR," +
                "fechaNac VARCHAR," +
                "correo VARCHAR," +
                "calleYNo VARCHAR," +
                "colonia VARCHAR," +
                "ciudad VARCHAR," +
                "estado VARCHAR," +
                "estadoCivil VARCHAR," +
                "enfermedades VARCHAR," +
                "nacionalidad VARCHAR," +
                "imagen VARCHAR," +
                "noNomina VARCHAR," +
                "area VARCHAR," +
                "puesto VARCHAR," +
                "rfc VARCHAR," +
                "curp VARCHAR," +
                "nss VARCHAR," +
                "contactoSOS VARCHAR," +
                "escolaridad VARCHAR," +
                "status VARCHAR);");

        Cursor cursor = database.query("Empleado",
                columnas,
                null,
                null,
                null,
                null,
                null);

        empleados = new ArrayList<>();

        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Empleado empleado = new Empleado();
                empleado.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                empleado.setApellidoP(cursor.getString(cursor.getColumnIndex("apellidoP")));
                empleado.setApellidoM(cursor.getString(cursor.getColumnIndex("apellidoM")));
                empleado.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
                empleado.setFechaNac(cursor.getString(cursor.getColumnIndex("fechaNac")));
                empleado.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                empleado.setCalleYNo(cursor.getString(cursor.getColumnIndex("calleYNo")));
                empleado.setColonia(cursor.getString(cursor.getColumnIndex("colonia")));
                empleado.setCiudad(cursor.getString(cursor.getColumnIndex("ciudad")));
                empleado.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
                empleado.setEstadoCivil(cursor.getString(cursor.getColumnIndex("estadoCivil")));
                empleado.setEnfermedades(cursor.getString(cursor.getColumnIndex("enfermedades")));
                empleado.setNacionalidad(cursor.getString(cursor.getColumnIndex("nacionalidad")));
                empleado.setImagen(cursor.getString(cursor.getColumnIndex("imagen")));
                empleado.setNoNomina(cursor.getString(cursor.getColumnIndex("noNomina")));
                empleado.setArea(cursor.getString(cursor.getColumnIndex("area")));
                empleado.setPuesto(cursor.getString(cursor.getColumnIndex("puesto")));
                empleado.setRfc(cursor.getString(cursor.getColumnIndex("rfc")));
                empleado.setCurp(cursor.getString(cursor.getColumnIndex("curp")));
                empleado.setNss(cursor.getString(cursor.getColumnIndex("nss")));
                empleado.setContactoSOS(cursor.getString(cursor.getColumnIndex("contactoSOS")));
                empleado.setEscolaridad(cursor.getString(cursor.getColumnIndex("escolaridad")));
                empleado.setStatus(cursor.getString(cursor.getColumnIndex("status")));

                empleados.add(empleado);
            }
        }

        //Instanciamos la vista del recycler view
        recyclerView = findViewById(R.id.rv_empleados);

        //Instanciamos el adapter, poniendole como contexto esta activity y asignadole como lista los mensajes anteriores
        adapter = new RVEmpleadoAdapter(this, empleados);

        //Asignamos el adapter al recyclerview
        recyclerView.setAdapter(adapter);

        //Asignamos el tipo de layout que queramos a nuestro recyclerview, linear, o cuadricula
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));

        /*recyclerView.setLayoutManager(new GridLayoutManager(this, 3));*/
    }

    public void registrar(View view) {
        Intent intent = new Intent(MainActivity.this, Formulario.class);

        intent.putExtra("noNomina", "0");
        intent.putExtra("accion", "Registrar");

        startActivity(intent);
    }

    public void buscar(View view) {
        empleados = new ArrayList<>();
        try {
            String selection = "nombre =? OR apellidoP =? OR apellidoM =? OR telefono =? OR" +
                    " fechaNac =? OR correo =? OR calleYNo =? OR colonia =? OR ciudad =? OR" +
                    " estado =? OR estadoCivil =? OR enfermedades =? OR nacionalidad =? OR imagen =? OR" +
                    " noNomina =? OR area =? OR puesto =? OR rfc =? OR curp =? OR nss =? OR" +
                    " contactoSOS =? OR escolaridad =? OR status =?";
            String[] selectionArgs = {editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim(), editBuscar.getText().toString().trim(),
                    editBuscar.getText().toString().trim()};

            database = openOrCreateDatabase("Directorio", Context.MODE_PRIVATE, null);
            Cursor cursor = database.query("Empleado",
                    columnas,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            if (cursor.getCount() != 0) {
                for (int i = 0; i < cursor.getCount(); i++) {
                    if (i != 0) {
                        cursor.moveToNext();
                    }
                    Empleado empleado = new Empleado();
                    empleado.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    empleado.setApellidoP(cursor.getString(cursor.getColumnIndex("apellidoP")));
                    empleado.setApellidoM(cursor.getString(cursor.getColumnIndex("apellidoM")));
                    empleado.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
                    empleado.setFechaNac(cursor.getString(cursor.getColumnIndex("fechaNac")));
                    empleado.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                    empleado.setCalleYNo(cursor.getString(cursor.getColumnIndex("calleYNo")));
                    empleado.setColonia(cursor.getString(cursor.getColumnIndex("colonia")));
                    empleado.setCiudad(cursor.getString(cursor.getColumnIndex("ciudad")));
                    empleado.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
                    empleado.setEstadoCivil(cursor.getString(cursor.getColumnIndex("estadoCivil")));
                    empleado.setEnfermedades(cursor.getString(cursor.getColumnIndex("enfermedades")));
                    empleado.setNacionalidad(cursor.getString(cursor.getColumnIndex("nacionalidad")));
                    empleado.setImagen(cursor.getString(cursor.getColumnIndex("imagen")));
                    empleado.setNoNomina(cursor.getString(cursor.getColumnIndex("noNomina")));
                    empleado.setArea(cursor.getString(cursor.getColumnIndex("area")));
                    empleado.setPuesto(cursor.getString(cursor.getColumnIndex("puesto")));
                    empleado.setRfc(cursor.getString(cursor.getColumnIndex("rfc")));
                    empleado.setCurp(cursor.getString(cursor.getColumnIndex("curp")));
                    empleado.setNss(cursor.getString(cursor.getColumnIndex("nss")));
                    empleado.setContactoSOS(cursor.getString(cursor.getColumnIndex("contactoSOS")));
                    empleado.setEscolaridad(cursor.getString(cursor.getColumnIndex("escolaridad")));
                    empleado.setStatus(cursor.getString(cursor.getColumnIndex("status")));

                    empleados.add(empleado);
                }
                adapter = new RVEmpleadoAdapter(this, empleados);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false));
                cursor.close();
            } else {
                Toast.makeText(getApplicationContext(), "No se encontraron coincidencias en la búsqueda", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "ERROOOOOR", Toast.LENGTH_LONG).show();
        }
    }
}