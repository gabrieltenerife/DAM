package com.example.ejercicioboton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var tv1: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.Numero)
        et2 = findViewById(R.id.Numero1)
        tv1 = findViewById(R.id.Resultado)
        button = findViewById(R.id.Boton)
    }

    @SuppressLint("SetTextI18n")
    fun sumanumeros(v: View?) {
        val nro1 = et1.text.toString().toInt()
        val nro2 = et2.text.toString().toInt()
        val suma = nro1 + nro2
        tv1.text = "Resultado: ${suma.toString()}"
    }
}