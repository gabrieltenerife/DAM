package com.example.cuestionario20.preguntas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cuestionario20.R

class Respuestas : AppCompatActivity() {

    lateinit var resultados : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultados)

        resultados = findViewById(R.id.nota)
        val resultadoTexto = StringBuilder()
        var bundle = intent.extras
        var respuestas = bundle?.getBooleanArray("Array")

        if (respuestas != null) {

            for((index,value)in respuestas.withIndex()){
                resultadoTexto.append("Respuesta $index: $value\n")
            }


        }


        resultados.text = resultadoTexto.toString()

    }
}