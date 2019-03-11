package com.example.rafapaniagua.navegacin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity2(View view){
        mascota = new Mascota("Richard Parker", "Cuyo", 3);

        Intent intent = new Intent(
                this,
                Activity2.class
        );

        //intent.putExtra("nombre", "Rafa");
        intent.putExtra("pet",mascota);

        startActivity(intent);
    }
}
