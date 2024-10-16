package com.example.persistenciaejercicio1

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var BotonGrabar : Button
    lateinit var BotonRecuperar : Button
    lateinit var Texto : TextView
    lateinit var Fecha : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        BotonGrabar = findViewById(R.id.grabar)
        BotonRecuperar = findViewById(R.id.recuperar)
        Texto = findViewById(R.id.texto)
        Fecha = findViewById(R.id.fecha)

        BotonGrabar.setOnClickListener {
            grabar()
        }

        BotonRecuperar.setOnClickListener {
            leer()
        }
    }

    fun grabar(){

        val nombrearchivo = Fecha.text.toString().replace("/","-")

        val archivo = OutputStreamWriter(openFileOutput(nombrearchivo, Activity.MODE_PRIVATE))
        archivo.write(Texto.text.toString())
        archivo.flush()
        archivo.close()

        Toast.makeText(this, "Datos grabados", Toast.LENGTH_SHORT).show()
        Fecha.setText("")
        Texto.setText("")

    }

    fun leer(){

        val nombrearchivo = Fecha.text.toString().replace("/","-")

        if(fileList().contains(nombrearchivo)){

            val archivo = InputStreamReader(openFileInput(nombrearchivo))
            val br = BufferedReader(archivo)

            var linea = br.readLine()
            val todo = StringBuilder()

            while (linea != null){
                todo.append(linea+"\n")
                linea = br.readLine()
            }

            br.close()
            archivo.close()

            Texto.setText(todo)

        } else {
            Toast.makeText(this, "No existe texto en esta fecha", Toast.LENGTH_SHORT).show()
            Fecha.setText("")
        }
    }
}