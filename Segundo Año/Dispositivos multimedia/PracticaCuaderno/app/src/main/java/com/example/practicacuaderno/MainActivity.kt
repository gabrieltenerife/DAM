package com.example.practicacuaderno

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var Spinner1: Spinner
    lateinit var Spinner2: Spinner
    lateinit var Spinner3: Spinner
    lateinit var Spinner4: Spinner
    lateinit var Boton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Spinner1 = findViewById(R.id.spinner)
        Spinner2 = findViewById(R.id.spinner2)
        Spinner3 = findViewById(R.id.spinner3)
        Spinner4 = findViewById(R.id.spinner4)
        Boton = findViewById(R.id.boton)

        var grosorhorizontales = ""
        var grosorverticales = ""

        var colorhorizontales = ""
        var colorverticales = ""

        //--------------------------------------------------------------------------
        // CONFIGURACION DE SPINNERS
        //--------------------------------------------------------------------------

        val spinner1 = arrayOf(
            "Grosor fino",
            "Grosor medio",
            "Grosor grueso"
        )
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner1)
        Spinner1.adapter = adaptador1

        //--------------------------------------------------------------------------

        val spinner2 = arrayOf(
            "Grosor fino",
            "Grosor medio",
            "Grosor grueso"
        )
        val adaptador2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner2)
        Spinner2.adapter = adaptador2

        //--------------------------------------------------------------------------

        val spinner3 = arrayOf(
            "Color Rojo",
            "Color Azul",
            "Color Amarillo"
        )
        val adaptador3 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner3)
        Spinner3.adapter = adaptador3

        //--------------------------------------------------------------------------

        val spinner4 = arrayOf(
            "Color Rojo",
            "Color Azul",
            "Color Amarillo"
        )
        val adaptador4 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner4)
        Spinner4.adapter = adaptador4

        //--------------------------------------------------------------------------

        Boton.setOnClickListener {
            // Recupera el valor seleccionado de cada Spinner
            grosorhorizontales = Spinner1.selectedItem.toString()
            grosorverticales = Spinner2.selectedItem.toString()
            colorhorizontales = Spinner3.selectedItem.toString()
            colorverticales = Spinner4.selectedItem.toString()

            // Crea el Intent y agrega los valores como extras
            val intento = Intent(this, Cuaderno::class.java)
            intento.putExtra("grosorhorizontales", grosorhorizontales)
            intento.putExtra("grosorverticales", grosorverticales)
            intento.putExtra("colorhorizontales", colorhorizontales)
            intento.putExtra("colorverticales", colorverticales)

            // Inicia la actividad Cuaderno
            startActivity(intento)
        }


    }
}