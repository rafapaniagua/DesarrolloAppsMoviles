package com.example.rafapaniagua.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txt_principal, txt_superior;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_punto, btn_igual,
            btn_borrar, btn_limpiar, btn_izquierda, btn_derecha,
            btn_suma, btn_resta, btn_multi, btn_div, btn_exp, btn_raiz,
            btn_fact, btn_porc, btn_recuperar;
    private String resultado, operador1, operador2, operacion, formato = "#.####";

    DecimalFormat auxiliar;

    int decimales = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_principal = (TextView) findViewById(R.id.txt_principal);
        txt_superior = (TextView) findViewById(R.id.txt_superior);

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

        btn_punto = (Button) findViewById(R.id.btn_punto);
        btn_borrar = (Button) findViewById(R.id.btn_borrar);
        btn_limpiar = (Button) findViewById(R.id.btn_limpiar);
        btn_igual = (Button) findViewById(R.id.btn_igual);

        btn_izquierda = (Button) findViewById(R.id.btn_izquierda);
        btn_derecha = (Button) findViewById(R.id.btn_derecha);

        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_resta = (Button) findViewById(R.id.btn_resta);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_div = (Button) findViewById(R.id.btn_div);

        btn_exp = (Button) findViewById(R.id.btn_exp);
        btn_raiz = (Button) findViewById(R.id.btn_raiz);
        btn_fact = (Button) findViewById(R.id.btn_fact);
        btn_porc = (Button) findViewById(R.id.btn_porc);

        btn_recuperar = (Button) findViewById(R.id.btn_recuperar);

        auxiliar = new DecimalFormat(formato);
    }

    public void eventoButton(View view){
        switch (view.getId()){
            case R.id.btn0:
                txt_principal.setText(txt_principal.getText().toString()+"0");
                txt_superior.setText(txt_superior.getText().toString()+"0");
                break;
            case R.id.btn1:
                txt_principal.setText(txt_principal.getText().toString()+"1");
                txt_superior.setText(txt_superior.getText().toString()+"1");
                break;
            case R.id.btn2:
                txt_principal.setText(txt_principal.getText().toString()+"2");
                txt_superior.setText(txt_superior.getText().toString()+"2");
                break;
            case R.id.btn3:
                txt_principal.setText(txt_principal.getText().toString()+"3");
                txt_superior.setText(txt_superior.getText().toString()+"3");
                break;
            case R.id.btn4:
                txt_principal.setText(txt_principal.getText().toString()+"4");
                txt_superior.setText(txt_superior.getText().toString()+"4");
                break;
            case R.id.btn5:
                txt_principal.setText(txt_principal.getText().toString()+"5");
                txt_superior.setText(txt_superior.getText().toString()+"5");
                break;
            case R.id.btn6:
                txt_principal.setText(txt_principal.getText().toString()+"6");
                txt_superior.setText(txt_superior.getText().toString()+"6");
                break;
            case R.id.btn7:
                txt_principal.setText(txt_principal.getText().toString()+"7");
                txt_superior.setText(txt_superior.getText().toString()+"7");
                break;
            case R.id.btn8:
                txt_principal.setText(txt_principal.getText().toString()+"8");
                txt_superior.setText(txt_superior.getText().toString()+"8");
                break;
            case R.id.btn9:
                txt_principal.setText(txt_principal.getText().toString()+"9");
                txt_superior.setText(txt_superior.getText().toString()+"9");
                break;
            case R.id.btn_punto:
                String textoActual = txt_principal.getText().toString();
                if (textoActual.length()<=0){
                    txt_principal.setText(textoActual+"0.");
                    txt_superior.setText(textoActual+"0.");
                } else{
                    if(!comprobarPunto(textoActual)){
                        txt_principal.setText(textoActual+".");
                        txt_superior.setText(textoActual+".");
                    }
                }
                break;
            case R.id.btn_borrar:
                String textoActual1, textoActual2;

                textoActual1 = txt_principal.getText().toString();
                if (textoActual1.length()>0){
                    textoActual1 = textoActual1.substring(0, textoActual1.length()-1);
                    txt_principal.setText(textoActual1);
                }

                textoActual2 = txt_superior.getText().toString();
                if (textoActual2.length()>0){
                    textoActual2 = textoActual2.substring(0, textoActual2.length()-1);
                    txt_superior.setText(textoActual2);
                }
                break;
            case R.id.btn_limpiar:
                txt_principal.setText("");
                txt_superior.setText("");
                operador1="";
                operador2="";
                operacion="";
                break;
            case R.id.btn_igual:
                operador2= txt_principal.getText().toString();
                if((!operador1.equals("")) || (!operador2.equals(""))){
                    resultado=procesar(operador1,operador2,operacion);
                    txt_principal.setText(auxiliar.format(Double.parseDouble(resultado)));
                    txt_superior.setText("");
                    operador1="";
                    operador2="";
                    operacion="";
                }
                break;
            case R.id.btn_izquierda:
                if (formato.length()>2) {
                    formato = formato.substring(0, formato.length() - 1);
                    auxiliar = new DecimalFormat(formato);
                    if (!resultado.equals("")) {
                        txt_principal.setText(auxiliar.format(Double.parseDouble(resultado)));
                    }
                    decimales--;
                }
                break;
            case R.id.btn_derecha:
                if (formato.length()<12){
                    formato = formato + "#";
                    auxiliar = new DecimalFormat(formato);
                    if(!resultado.equals("")){
                        txt_principal.setText(auxiliar.format(Double.parseDouble(resultado)));
                    }
                    decimales++;
                }
                break;
            case R.id.btn_suma:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="suma";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"+");
                }
                break;
            case R.id.btn_resta:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="resta";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"-");
                }
                break;
            case R.id.btn_multi:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="multiplicacion";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"*");
                }
                break;
            case R.id.btn_div:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="division";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"/");
                }
                break;
            case R.id.btn_exp:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="exponente";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"^");
                }
                break;
            case R.id.btn_raiz:
                Double raiz = Math.sqrt(Double.parseDouble(txt_principal.getText().toString()));
                txt_principal.setText(String.valueOf(raiz));
                resultado = txt_principal.getText().toString();
                txt_principal.setText(auxiliar.format(raiz));
                txt_superior.setText("");
                operador1="";
                operador2="";
                operacion="";
                break;
            case R.id.btn_fact:
                int numero, acumulado=1;
                if(!comprobarPunto(txt_principal.getText().toString())){
                    numero = Integer.parseInt(txt_principal.getText().toString());
                    for (int i = 1; i <= numero; i++) {
                        acumulado = acumulado*i;
                    }
                    txt_principal.setText(String.valueOf(acumulado));
                    resultado = txt_principal.getText().toString();
                    txt_superior.setText("");
                    operador1="";
                    operador2="";
                    operacion="";
                }
            case R.id.btn_porc:
                if(!txt_principal.getText().toString().equals("")){
                    operador1= txt_principal.getText().toString();
                    operacion="porcentaje";
                    txt_principal.setText("");
                    txt_superior.setText(txt_superior.getText().toString()+"%");
                }
                break;
            case R.id.btn_recuperar:
                txt_principal.setText(txt_principal.getText().toString()+auxiliar.format(Double.parseDouble(resultado)));
                txt_superior.setText(txt_superior.getText().toString()+auxiliar.format(Double.parseDouble(resultado)));
                break;
        }
    }

    public boolean comprobarPunto(String textoActual){
        for (int i = 0; i < textoActual.length(); i++) {
            if (textoActual.charAt(i)=='.'){
                return true;
            }
        }
        return false;
    }

    public String procesar(String operador1, String operador2, String operacion){
        Double resultado=0.0;
        //String respuesta;
        if (operacion.equals("suma")){
            resultado= Double.parseDouble(operador1)+Double.parseDouble(operador2);
        } else if (operacion.equals("resta")){
            resultado= Double.parseDouble(operador1)-Double.parseDouble(operador2);
        } else if (operacion.equals("multiplicacion")){
            resultado= Double.parseDouble(operador1)*Double.parseDouble(operador2);
        } else if (operacion.equals("division")){
            resultado= Double.parseDouble(operador1)/Double.parseDouble(operador2);
        } else if (operacion.equals("exponente")){
            resultado = Math.pow(Double.parseDouble(operador1),Double.parseDouble(operador2));
        } else if (operacion.equals("porcentaje")){
            resultado= Double.parseDouble(operador1)*(Double.parseDouble(operador2)/100);
        }
        //respuesta = String.valueOf(resultado);
        return resultado.toString();
    }
}
