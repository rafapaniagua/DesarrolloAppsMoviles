package com.example.empleados;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class VistaRapida extends AppCompatActivity {

    SQLiteDatabase database;

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String noNomina;
    private String telefono;
    private String area;
    private String imagen;

    private TextView tvNombre;
    private TextView tvApellidoP;
    private TextView tvApellidoM;
    private TextView tvNoNomina;
    private TextView tvTelefono;
    private TextView tvArea;

    private ImageButton btnImagen;

    private String pathImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_rapida);

        database = openOrCreateDatabase("Directorio", Context.MODE_PRIVATE, null);

        nombre = getIntent().getExtras().getString("nombre");
        apellidoP = getIntent().getExtras().getString("apellidoP");
        apellidoM = getIntent().getExtras().getString("apellidoM");
        noNomina = getIntent().getExtras().getString("noNomina");
        telefono= getIntent().getExtras().getString("telefono");
        area = getIntent().getExtras().getString("area");
        imagen = getIntent().getExtras().getString("imagen");

        tvNombre = (TextView) findViewById(R.id.tv_nombre_rapida);
        tvNombre.setText(nombre);

        tvApellidoP = (TextView) findViewById(R.id.tv_apellidoP_rapida);
        tvApellidoP.setText(apellidoP);

        tvApellidoM = (TextView) findViewById(R.id.tv_apellidoM_rapida);
        tvApellidoM.setText(apellidoM);

        tvNoNomina = (TextView) findViewById(R.id.tv_noNomina_rapida);
        tvNoNomina.setText(noNomina);

        tvTelefono = (TextView) findViewById(R.id.tv_telefono_rapida);
        tvTelefono.setText(telefono);

        tvArea = (TextView) findViewById(R.id.tv_area_rapida);
        tvArea.setText(area);

        btnImagen = (ImageButton) findViewById(R.id.btnImagen);
        if(!imagen.equals("")){
            //Toast.makeText(getApplicationContext(), "SI: " + imagen, Toast.LENGTH_LONG).show();
            Uri path = Uri.parse(imagen);
            btnImagen.setImageURI(path);
        } else {
            //Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
        }
    }

    public void editar(View view) {
        Intent intent = new Intent(VistaRapida.this, Formulario.class);

        intent.putExtra("noNomina", noNomina);
        intent.putExtra("accion", "Actualizar");

        startActivity(intent);
    }


    public void personal(View view) {
        Intent intent = new Intent(VistaRapida.this, InfoPersonal.class);

        intent.putExtra("noNomina", noNomina);

        startActivity(intent);
    }


    public void laboral(View view) {
        Intent intent = new Intent(VistaRapida.this, InfoLaboral.class);

        intent.putExtra("noNomina", noNomina);

        startActivity(intent);
    }

    static final int REQUEST_SHOW_IMAGE = 10;
    public void cargarImagen(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser
                        (intent,"Seleccionar aplicación"),
                REQUEST_SHOW_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_SHOW_IMAGE){
            Uri path = data.getData();
            pathImagen= path.toString();
            //Log.e("Imagen",pathImagen);
            //Toast.makeText(getApplicationContext(),pathImagen,Toast.LENGTH_LONG).show();
            btnImagen.setImageURI(path);

            ContentValues dato = new ContentValues();

            dato.put("imagen", pathImagen);

            database.update("Empleado", dato, "noNomina =?", new String[]{noNomina});
            Toast.makeText(getApplicationContext(), "Imagen agregada exitosamente" ,Toast.LENGTH_LONG).show();
        }
    }
}
