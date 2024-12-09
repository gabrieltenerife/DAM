package com.example.cuestionario20.preguntas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cuestionario20.R


class Pregunta10 : AppCompatActivity() {

    lateinit var r1: RadioButton
    lateinit var r2: RadioButton
    lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta10)

        r1 = findViewById(R.id.r1)
        r2 = findViewById(R.id.r2)
        boton = findViewById(R.id.boton)

        boton.setOnClickListener {
            respuesta()
        }
    }

    fun respuesta() {

        val bundle = intent.extras

        val respuestas = bundle?.getBooleanArray("Array")!!
        var posicion = bundle?.getInt("Posicion")!!
        var user = bundle?.getString("usuario")
        var ready = false

        if (r1.isChecked || r2.isChecked) {
            if (r1.isChecked) {
                respuestas[posicion] = true
                ready = true
            } else {
                respuestas[posicion] = false
                ready = true
            }
        } else Toast.makeText(
            this,
            "Debe selecccionar una opcion para continuar",
            Toast.LENGTH_SHORT
        ).show()

        if (ready) {
            val intento = Intent(this, ResultadosActivity::class.java)
            intento.putExtra("Array", respuestas)
            intento.putExtra("Posicion", posicion)
            intento.putExtra("usuario", user)
            startActivity(intento)
        }
    }
}