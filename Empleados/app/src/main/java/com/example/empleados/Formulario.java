package com.example.empleados;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    SQLiteDatabase database;

    private String accion;
    private String nomina;

    private EditText nombre;
    private EditText apellidoP;
    private EditText apellidoM;
    private EditText telefono;
    private EditText fechaNac;
    private EditText correo;
    private EditText calleYNo;
    private EditText colonia;
    private EditText ciudad;
    private EditText estado;
    private EditText estadoCivil;
    private EditText enfermedades;
    private EditText nacionalidad;
    private EditText noNomina;
    private EditText area;
    private EditText puesto;
    private EditText rfc;
    private EditText curp;
    private EditText nss;
    private EditText contactoSOS;
    private EditText escolaridad;
    private EditText status;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nomina = getIntent().getExtras().getString("noNomina");

        database = openOrCreateDatabase("Directorio", Context.MODE_PRIVATE, null);

        nombre = (EditText) findViewById(R.id.et_nombre_form);
        apellidoP = (EditText) findViewById(R.id.et_apellidoP_form);
        apellidoM = (EditText) findViewById(R.id.et_apellidoM_form);
        telefono = (EditText) findViewById(R.id.et_telefono_form);
        fechaNac= (EditText) findViewById(R.id.et_fechaNac_form);
        correo = (EditText) findViewById(R.id.et_correo_form);
        calleYNo = (EditText) findViewById(R.id.et_calleYNo_form);
        colonia = (EditText) findViewById(R.id.et_colonia_form);
        ciudad = (EditText) findViewById(R.id.et_ciudad_form);
        estado = (EditText) findViewById(R.id.et_estado_form);
        estadoCivil = (EditText) findViewById(R.id.et_estadoCivil_form);
        enfermedades = (EditText) findViewById(R.id.et_enfermedades_form);
        nacionalidad = (EditText) findViewById(R.id.et_nacionalidad_form);
        noNomina = (EditText) findViewById(R.id.et_noNomina_form);
        area = (EditText) findViewById(R.id.et_area_form);
        puesto = (EditText) findViewById(R.id.et_puesto_form);
        rfc = (EditText) findViewById(R.id.et_rfc_form);
        curp = (EditText) findViewById(R.id.et_curp_form);
        nss = (EditText) findViewById(R.id.et_nss_form);
        contactoSOS = (EditText) findViewById(R.id.et_contactoSOS_form);
        escolaridad = (EditText) findViewById(R.id.et_escolaridad_form);
        status = (EditText) findViewById(R.id.et_status_form);

        accion = getIntent().getExtras().getString("accion");

        if(accion.equals("Actualizar")) {
            obtenerDatos();
        }
    }

    public void obtenerDatos() {
        Cursor cursor = database.query("Empleado",
                columnas,
                "noNomina =?",
                new String[]{nomina},
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

        nombre.setText(empleado.getNombre());
        apellidoP.setText(empleado.getApellidoP());
        apellidoM.setText(empleado.getApellidoM());
        telefono.setText(empleado.getTelefono());
        fechaNac.setText(empleado.getFechaNac());
        correo.setText(empleado.getCorreo());
        calleYNo.setText(empleado.getCalleYNo());
        colonia.setText(empleado.getColonia());
        ciudad.setText(empleado.getCiudad());
        estado.setText(empleado.getEstado());
        estadoCivil.setText(empleado.getEstadoCivil());
        enfermedades.setText(empleado.getEnfermedades());
        nacionalidad.setText(empleado.getNacionalidad());
        noNomina.setText(empleado.getNoNomina());
        area.setText(empleado.getArea());
        puesto.setText(empleado.getPuesto());
        rfc.setText(empleado.getRfc());
        curp.setText(empleado.getCurp());
        nss.setText(empleado.getNss());
        contactoSOS.setText(empleado.getContactoSOS());
        escolaridad.setText(empleado.getEscolaridad());
        status.setText(empleado.getStatus());
    }

    public void guardarFormulario(View view) {

        if(nombre.getText().toString().trim().length()==0||
            apellidoP.getText().toString().trim().length()==0||
            apellidoM.getText().toString().trim().length()==0||
            telefono.getText().toString().trim().length()==0||
            fechaNac.getText().toString().trim().length()==0||
            correo.getText().toString().trim().length()==0||
            calleYNo.getText().toString().trim().length()==0||
            colonia.getText().toString().trim().length()==0||
            ciudad.getText().toString().trim().length()==0||
            estado.getText().toString().trim().length()==0||
            estadoCivil.getText().toString().trim().length()==0||
            enfermedades.getText().toString().trim().length()==0||
            nacionalidad.getText().toString().trim().length()==0||
            noNomina.getText().toString().trim().length()==0||
            area.getText().toString().trim().length()==0||
            puesto.getText().toString().trim().length()==0||
            rfc.getText().toString().trim().length()==0||
            curp.getText().toString().trim().length()==0||
            nss.getText().toString().trim().length()==0||
            contactoSOS.getText().toString().trim().length()==0||
            escolaridad.getText().toString().trim().length()==0||
            status.getText().toString().trim().length()==0)
        {
            Toast.makeText(getApplicationContext(), "Favor de completar todos los campos" ,Toast.LENGTH_LONG).show();
        } else {
            try {
                ContentValues datos = new ContentValues();

                datos.put("nombre", nombre.getText().toString());
                datos.put("apellidoP", apellidoP.getText().toString());
                datos.put("apellidoM", apellidoM.getText().toString());
                datos.put("telefono", telefono.getText().toString());
                datos.put("fechaNac", fechaNac.getText().toString());
                datos.put("correo", correo.getText().toString());
                datos.put("calleYNo", calleYNo.getText().toString());
                datos.put("colonia", colonia.getText().toString());
                datos.put("ciudad", ciudad.getText().toString());
                datos.put("estado", estado.getText().toString());
                datos.put("estadoCivil", estadoCivil.getText().toString());
                datos.put("enfermedades", enfermedades.getText().toString());
                datos.put("nacionalidad", nacionalidad.getText().toString());
                datos.put("imagen", "");
                datos.put("noNomina", noNomina.getText().toString());
                datos.put("area", area.getText().toString());
                datos.put("puesto", puesto.getText().toString());
                datos.put("rfc", rfc.getText().toString());
                datos.put("curp", curp.getText().toString());
                datos.put("nss", nss.getText().toString());
                datos.put("contactoSOS", contactoSOS.getText().toString());
                datos.put("escolaridad", escolaridad.getText().toString());
                datos.put("status", status.getText().toString());

                if(accion.equals("Registrar")) {
                    database.insert("Empleado", null, datos);
                    Toast.makeText(getApplicationContext(), "Empleado " + nombre.getText().toString() + " agregado exitosamente" ,Toast.LENGTH_LONG).show();
                } else if(accion.equals("Actualizar")) {
                    database.update("Empleado", datos, "noNomina =?", new String[]{nomina});
                    Toast.makeText(getApplicationContext(), "Empleado " + nombre.getText().toString() + " actualizado exitosamente" ,Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(Formulario.this, MainActivity.class);
                startActivity(intent);

                finish();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR EN LA BASE DE DATOS" ,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Formulario.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        }
    }
}
