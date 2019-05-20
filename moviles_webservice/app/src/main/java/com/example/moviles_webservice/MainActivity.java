package com.example.moviles_webservice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private final String BASEURL = "http://192.168.137.1:8000/api/mascota/";

    //AL INICIAR EL SERVICIO DE LARAVEL HAY QUE EJECUTAR ESTE COMANDO
    //php artisan serve --host 0.0.0.0 -- port 8000

    private EditText et_id, et_nombre, et_raza, et_edad;
    private Button btn_buscar, btn_agregar, btn_actualizar, btn_eliminar;

    private Context ctx;
    private StringRequest strq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;
        requestQueue = Volley.newRequestQueue(ctx);

        et_id = (EditText) findViewById(R.id.et_id);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_raza = (EditText) findViewById(R.id.et_raza);
        et_edad = (EditText) findViewById(R.id.et_edad);

        btn_buscar = (Button) findViewById(R.id.btn_buscar);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);
        btn_actualizar = (Button) findViewById(R.id.btn_actualizar);
        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                store();
            }
        });

        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destroy();
            }
        });
    }

    private void show() {
        strq = new StringRequest(Request.Method.GET, BASEURL+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Mascota encontrada", Toast.LENGTH_SHORT).show();
                        recuperarDatos(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Lo siento, no se encontró ninguna mascota en la búsqueda", Toast.LENGTH_SHORT).show();
                et_id.setText("");
                et_nombre.setText("");
                et_raza.setText("");
                et_edad.setText("");
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("raza", et_raza.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    private void store() {
        strq = new StringRequest(Request.Method.POST, BASEURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Mascota agregada exitosamente", Toast.LENGTH_LONG).show();
                        recuperarDatos(response);
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Lo siento, ha ocurrido un error\nal guardar la información", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("raza", et_raza.getText().toString());
                parametros.put("edad", et_edad.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    private void update() {
        strq = new StringRequest(Request.Method.PUT, BASEURL+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Los datos de la mascota\nfueron actualizados exitosamente", Toast.LENGTH_LONG).show();
                        recuperarDatos(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Lo siento,\nNo se encontró la mascota seleccionada", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("id", et_id.getText().toString());
                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("raza", et_raza.getText().toString());
                parametros.put("edad", et_edad.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    private void destroy() {
        strq = new StringRequest(Request.Method.DELETE, BASEURL+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Mascota Eliminada Exitosamente", Toast.LENGTH_SHORT).show();
                        et_id.setText("");
                        et_nombre.setText("");
                        et_raza.setText("");
                        et_edad.setText("");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Lo siento, no existe la mascota", Toast.LENGTH_LONG).show();
                et_id.setText("");
                et_nombre.setText("");
                et_raza.setText("");
                et_edad.setText("");
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("raza", et_raza.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    public void recuperarDatos(String res) {
        try {
            JSONObject object = new JSONObject(res);

            /*String success = object.get("success").toString();
            String result = object.get("result").toString();
            String errors = object.get("errors").toString();*/

            //if (success.equals("true")){
                //JSONObject json_result = new JSONObject(result);

                et_id.setText(object.get("id").toString());
                et_nombre.setText(object.get("nombre").toString());
                et_raza.setText(object.get("raza").toString());
                et_edad.setText(object.get("edad").toString());
            //}else{
                //Toast.makeText(ctx, "Error: " + errors, Toast.LENGTH_SHORT).show();
            //}

        }catch (JSONException e){
            e.getMessage();
            Toast.makeText(ctx, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }
}
