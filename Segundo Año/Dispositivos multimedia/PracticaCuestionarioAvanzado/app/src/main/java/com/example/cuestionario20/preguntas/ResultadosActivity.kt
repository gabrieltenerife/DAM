package com.example.cuestionario20.preguntas

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cuestionario20.AdminSQLiteOpenHelper
import com.example.cuestionario20.BienvenidaActivity
import com.example.cuestionario20.LoginActivity
import com.example.cuestionario20.R

class ResultadosActivity : AppCompatActivity() {

    lateinit var resultados: TextView
    lateinit var correccion: TextView
    lateinit var notamasalta: TextView
    lateinit var volver : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultados)

        resultados = findViewById(R.id.nota)
        correccion = findViewById(R.id.correccion)
        notamasalta = findViewById(R.id.notamasalta)
        volver = findViewById(R.id.volver)

        var bundle = intent.extras
        var respuestas = bundle?.getBooleanArray("Array")!!
        var user = bundle?.getString("usuario")!!

        val correcion =
            booleanArrayOf(true, false, false, true, true, true, false, true, false, true)
        var aciertos = 0;

        for ((index, value) in respuestas.withIndex()) {
            if (value.equals(correcion[index])) {
                aciertos++
            }
        }
        resultados.setText("Tu nota es de ${aciertos.toString()}pts.")

        val mostrarcorrectas = StringBuilder()
        for ((index, value) in respuestas.withIndex()) {
            if (!value.equals(correcion[index])) {
                mostrarcorrectas.append("Su respuesta $index es incorrecta,la correcta era: $value\n")
            }
        }
        correccion.setText(mostrarcorrectas)

        subirnota(aciertos, user)

        volver.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

    fun subirnota(nota: Int, usuario: String) {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        val buscar = db.rawQuery(
            "SELECT nota FROM usuarios WHERE usuario = ?",
            arrayOf(usuario)
        )

        if (buscar.moveToFirst()) {

            if (buscar.getInt(0) == null) {

                val registro = ContentValues()
                registro.put("nota", nota)
                val cant = db.update("usuarios", registro, "usuario = ?", arrayOf(usuario))

                if (cant == 1) {
                    Toast.makeText(this, "Ocurrio un error guardando la nota", Toast.LENGTH_SHORT)
                        .show()
                }
                notamasalta.setText("Felicidades tu nueva nota mas alta es de: " + nota + "pts")
            }

            if (buscar.getInt(0) < nota) {

                val registro = ContentValues()
                registro.put("nota", nota)
                val cant = db.update("usuarios", registro, "usuario = ?", arrayOf(usuario))

                if (cant == 1) {
                    Toast.makeText(this, "Ocurrio un error guardando la nota", Toast.LENGTH_SHORT)
                        .show()
                }

                notamasalta.setText("Felicidades!! tu nota mas alta es de: " + nota + "pts")
            }
        }

        db.close()
    }
}