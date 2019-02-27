package com.example.rafapaniagua.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView pantalla;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnpunto, btnmask,
            btnborrar, btnlimpiar, btnigual, btnarriba, btnabajo, btnizquierda, btnderecha,
            btnsubnet, btnsuma, btnresta, btnmultiplicacion, btndivision, btnexponente, btnraiz,
            btnfactorial, btnporcentaje, btnrecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = (TextView) findViewById(R.id.pantalla);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnpunto = (Button) findViewById(R.id.btnpunto);
        btnmask = (Button) findViewById(R.id.btnmask);
        btnborrar = (Button) findViewById(R.id.btnborrar);
        btnlimpiar = (Button) findViewById(R.id.btnlimpiar);
        btnigual = (Button) findViewById(R.id.btnigual);

        btnarriba = (Button) findViewById(R.id.btnarriba);
        btnabajo = (Button) findViewById(R.id.btnabajo);
        btnizquierda = (Button) findViewById(R.id.btnizquierda);
        btnderecha = (Button) findViewById(R.id.btnderecha);

        btnsubnet = (Button) findViewById(R.id.btnsubnet);

        btnsuma = (Button) findViewById(R.id.btnsuma);
        btnresta = (Button) findViewById(R.id.btnresta);
        btnmultiplicacion = (Button) findViewById(R.id.btnmultiplicacion);
        btndivision = (Button) findViewById(R.id.btndivision);

        btnexponente = (Button) findViewById(R.id.btnexponente);
        btnraiz = (Button) findViewById(R.id.btnraiz);
        btnfactorial = (Button) findViewById(R.id.btnfactorial);
        btnporcentaje = (Button) findViewById(R.id.btnporcentaje);

        btnrecuperar = (Button) findViewById(R.id.btnrecuperar);
    }

    public void eventoButton(View view){
        switch (view.getId()){
            case R.id.btn0:
                pantalla.setText(pantalla.getText().toString()+"0");
                break;
            case R.id.btn1:
                pantalla.setText(pantalla.getText().toString()+"1");
                break;
            case R.id.btn2:
                pantalla.setText(pantalla.getText().toString()+"2");
                break;
            case R.id.btn3:
                pantalla.setText(pantalla.getText().toString()+"3");
                break;
            case R.id.btn4:
                pantalla.setText(pantalla.getText().toString()+"4");
                break;
            case R.id.btn5:
                pantalla.setText(pantalla.getText().toString()+"5");
                break;
            case R.id.btn6:
                pantalla.setText(pantalla.getText().toString()+"6");
                break;
            case R.id.btn7:
                pantalla.setText(pantalla.getText().toString()+"7");
                break;
            case R.id.btn8:
                pantalla.setText(pantalla.getText().toString()+"8");
                break;
            case R.id.btn9:
                pantalla.setText(pantalla.getText().toString()+"9");
                break;
            case R.id.btnpunto:
                pantalla.setText(pantalla.getText().toString()+".");
                break;
            case R.id.btnmask:
                pantalla.setText(pantalla.getText().toString()+"/");
                break;
            case R.id.btnborrar:

                break;
            case R.id.btnlimpiar:
                pantalla.setText("");
                break;
            case R.id.btnigual:
                pantalla.setText(pantalla.getText().toString()+"=");
                break;
            case R.id.btnarriba:

                break;
            case R.id.btnabajo:

                break;
            case R.id.btnizquierda:

                break;
            case R.id.btnderecha:

                break;
            case R.id.btnsubnet:

                break;
            case R.id.btnsuma:
                pantalla.setText(pantalla.getText().toString()+"+");
                break;
            case R.id.btnresta:
                pantalla.setText(pantalla.getText().toString()+"-");
                break;
            case R.id.btnmultiplicacion:
                pantalla.setText(pantalla.getText().toString()+"*");
                break;
            case R.id.btndivision:
                pantalla.setText(pantalla.getText().toString()+"/");
                break;
            case R.id.btnexponente:
                pantalla.setText(pantalla.getText().toString()+"^");
                break;
            case R.id.btnraiz:
                pantalla.setText(pantalla.getText().toString()+"¹");
                break;
            case R.id.btnfactorial:
                pantalla.setText(pantalla.getText().toString()+"!");
                break;
            case R.id.btnporcentaje:
                pantalla.setText(pantalla.getText().toString()+"%");
                break;
            case R.id.btnrecuperar:

                break;
        }

    }
}
