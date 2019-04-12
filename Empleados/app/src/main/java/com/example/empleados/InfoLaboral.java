package com.example.empleados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InfoLaboral extends AppCompatActivity {

    private String noNomina;

    private EditText etNoNomina;
    private EditText etArea;
    private EditText etPuesto;
    private EditText etRfc;
    private EditText etCurp;
    private EditText etNss;
    private EditText etContactoSOS;
    private EditText etEscolaridad;
    private EditText etStatus;

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
        setContentView(R.layout.activity_info_laboral);

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

        etNoNomina = (EditText) findViewById(R.id.et_noNomina_laboral);
        etNoNomina.setText(empleado.getNoNomina());
        etNoNomina.setEnabled(false);

        etArea = (EditText) findViewById(R.id.et_area_laboral);
        etArea.setText(empleado.getArea());
        etArea.setEnabled(false);

        etPuesto = (EditText) findViewById(R.id.et_puesto_laboral);
        etPuesto.setText(empleado.getPuesto());
        etPuesto.setEnabled(false);

        etRfc = (EditText) findViewById(R.id.et_rfc_laboral);
        etRfc.setText(empleado.getRfc());
        etRfc.setEnabled(false);

        etCurp = (EditText) findViewById(R.id.et_curp_laboral);
        etCurp.setText(empleado.getCurp());
        etCurp.setEnabled(false);

        etNss = (EditText) findViewById(R.id.et_nss_laboral);
        etNss.setText(empleado.getNss());
        etNss.setEnabled(false);

        etContactoSOS = (EditText) findViewById(R.id.et_contactoSOS_laboral);
        etContactoSOS.setText(empleado.getContactoSOS());
        etContactoSOS.setEnabled(false);

        etEscolaridad = (EditText) findViewById(R.id.et_escolaridad_laboral);
        etEscolaridad.setText(empleado.getEscolaridad());
        etEscolaridad.setEnabled(false);

        etStatus = (EditText) findViewById(R.id.et_status_laboral);
        etStatus.setText(empleado.getStatus());
        etStatus.setEnabled(false);
    }
}
