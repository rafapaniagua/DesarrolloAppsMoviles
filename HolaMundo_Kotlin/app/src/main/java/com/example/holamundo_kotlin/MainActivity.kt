package com.example.holamundo_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // agrega un saludo a la pantalla
        textView_HelloWorld.text="Saludos desde Kotlin"; // -> así se hace en Android-Kotlin
    }
}
