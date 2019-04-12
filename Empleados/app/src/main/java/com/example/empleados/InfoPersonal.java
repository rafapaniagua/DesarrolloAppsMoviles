package com.example.empleados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InfoPersonal extends AppCompatActivity {

    private String noNomina;

    private EditText etNombre;
    private EditText etApellidoP;
    private EditText etApellidoM;
    private EditText etTelefono;
    private EditText etFechaNac;
    private EditText etCorreo;
    private EditText etCalleYNo;
    private EditText etColonia;
    private EditText etCiudad;
    private EditText etEstado;
    private EditText etEstadoCivil;
    private EditText etEnfermedades;
    private EditText etNacionalidad;

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

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_personal);

        noNomina = getIntent().getExtras().getString("noNomina");

        database = openOrCreateDatabase("Directorio", Context.MODE_PRIVATE, null);

        Cursor cursor = database.query("Empleado",
                columnas,
                "noNomina =?",
                new String[]{noNomina},
                null,
                null,
                null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Empleado empleado = new Empleado(
                cursor.getString(cursor.getColumnIndex("nombre")),
                cursor.getString(cursor.getColumnIndex("apellidoP")),
                cursor.getString(cursor.getColumnIndex("apellidoM")),
                cursor.getString(cursor.getColumnIndex("telefono")),
                cursor.getString(cursor.getColumnIndex("fechaNac")),
                cursor.getString(cursor.getColumnIndex("correo")),
                cursor.getString(cursor.getColumnIndex("calleYNo")),
                cursor.getString(cursor.getColumnIndex("colonia")),
                cursor.getString(cursor.getColumnIndex("ciudad")),
                cursor.getString(cursor.getColumnIndex("estado")),
                cursor.getString(cursor.getColumnIndex("estadoCivil")),
                cursor.getString(cursor.getColumnIndex("enfermedades")),
                cursor.getString(cursor.getColumnIndex("nacionalidad")),
                cursor.getString(cursor.getColumnIndex("imagen")),
                cursor.getString(cursor.getColumnIndex("noNomina")),
                cursor.getString(cursor.getColumnIndex("area")),
                cursor.getString(cursor.getColumnIndex("puesto")),
                cursor.getString(cursor.getColumnIndex("rfc")),
                cursor.getString(cursor.getColumnIndex("curp")),
                cursor.getString(cursor.getColumnIndex("nss")),
                cursor.getString(cursor.getColumnIndex("contactoSOS")),
                cursor.getString(cursor.getColumnIndex("escolaridad")),
                cursor.getString(cursor.getColumnIndex("status"))
        );

        etNombre = (EditText) findViewById(R.id.et_nombre_personal);
        etNombre.setText(empleado.getNombre());
        etNombre.setEnabled(false);

        etApellidoP = (EditText) findViewById(R.id.et_apellidoP_personal);
        etApellidoP.setText(empleado.getApellidoP());
        etApellidoP.setEnabled(false);

        etApellidoM = (EditText) findViewById(R.id.et_apellidoM_personal);
        etApellidoM.setText(empleado.getApellidoM());
        etApellidoM.setEnabled(false);

        etTelefono = (EditText) findViewById(R.id.et_telefono_personal);
        etTelefono.setText(empleado.getTelefono());
        etTelefono.setEnabled(false);

        etFechaNac = (EditText) findViewById(R.id.et_fechaNac_personal);
        etFechaNac.setText(empleado.getFechaNac());
        etFechaNac.setEnabled(false);

        etCorreo = (EditText) findViewById(R.id.et_correo_personal);
        etCorreo.setText(empleado.getCorreo());
        etCorreo.setEnabled(false);

        etCalleYNo = (EditText) findViewById(R.id.et_calleYNo_personal);
        etCalleYNo.setText(empleado.getCalleYNo());
        etCalleYNo.setEnabled(false);

        etColonia = (EditText) findViewById(R.id.et_colonia_personal);
        etColonia.setText(empleado.getColonia());
        etColonia.setEnabled(false);

        etCiudad = (EditText) findViewById(R.id.et_ciudad_personal);
        etCiudad.setText(empleado.getCiudad());
        etCiudad.setEnabled(false);

        etEstado = (EditText) findViewById(R.id.et_estado_personal);
        etEstado.setText(empleado.getEstado());
        etEstado.setEnabled(false);

        etEstadoCivil = (EditText) findViewById(R.id.et_estadoCivil_personal);
        etEstadoCivil.setText(empleado.getEstadoCivil());
        etEstadoCivil.setEnabled(false);

        etEnfermedades = (EditText) findViewById(R.id.et_enfermedades_personal);
        etEnfermedades.setText(empleado.getEnfermedades());
        etEnfermedades.setEnabled(false);

        etNacionalidad = (EditText) findViewById(R.id.et_nacionalidad_personal);
        etNacionalidad.setText(empleado.getNacionalidad());
        etNacionalidad.setEnabled(false);
    }
}
