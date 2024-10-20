package com.example.actividadguiadaintent

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    lateinit var boton : Button
    lateinit var visualizador : WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        boton = findViewById(R.id.button2)
        visualizador = findViewById(R.id.web)

        val bundle = intent.extras
        val url = bundle?.getString("direccion")


        visualizador.loadUrl("https://www.${url}.com")

        boton.setOnClickListener{
            finish()
        }


    }
}