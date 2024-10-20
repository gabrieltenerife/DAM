package com.example.actividadguiadaintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    lateinit var contra : EditText
    lateinit var url : EditText
    lateinit var boton : Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.button)
        contra = findViewById(R.id.contra)
        url = findViewById(R.id.editTextText2)

        boton.setOnClickListener{
            comprobar()
        }
    }

    fun comprobar(){
        if(contra.text.toString() == "contraseña"){
            val intento = Intent(this,MainActivity2::class.java)
            intento.putExtra("direccion",url.text.toString())
            startActivity(intento)
        }
    }
}