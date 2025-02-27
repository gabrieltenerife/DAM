package com.example.cuestionario20.preguntas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cuestionario20.R
import java.util.ArrayList

class Pregunta1 : AppCompatActivity() {

    lateinit var r1: RadioButton
    lateinit var r2: RadioButton
    lateinit var boton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta1)

        r1 = findViewById(R.id.r1)
        r2 = findViewById(R.id.r2)
        boton = findViewById(R.id.boton)

        boton.setOnClickListener {
            respuesta()
        }
    }

    fun respuesta() {

        var bundle = intent.extras
        var user = bundle?.getString("usuario")

        val respuestas = BooleanArray(10)
        var posicion = 0
        var ready = false

        if (r1.isChecked || r2.isChecked) {
            if (r1.isChecked) {
                respuestas[posicion] = true
                posicion++
                ready = true
            } else {
                respuestas[posicion] = false
                posicion++
                ready = true
            }
        } else Toast.makeText(
            this,
            "Debe selecccionar una opcion para continuar",
            Toast.LENGTH_SHORT
        ).show()

        if (ready) {
            val intento = Intent(this, Pregunta2::class.java)
            intento.putExtra("Array", respuestas)
            intento.putExtra("Posicion", posicion)
            intento.putExtra("usuario", user)
            startActivity(intento)
        }
    }
}