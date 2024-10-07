package com.example.cuestionario

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Creamos las variables
    /*
    lateinit var Numa: EditText
    lateinit var Sum: Button
    lateinit var Pantalla: TextView
   */


    //Pregunta 0
    lateinit var P0a: CheckBox
    lateinit var P0b: CheckBox
    lateinit var P0c: CheckBox
    lateinit var P0t: TextView

    //Pregunta 1
    lateinit var P1a: CheckBox
    lateinit var P1b: CheckBox
    lateinit var P1c: CheckBox
    lateinit var P1t: TextView

    //Pregunta 2
    lateinit var P2a: CheckBox
    lateinit var P2b: CheckBox
    lateinit var P2c: CheckBox
    lateinit var P2t: TextView

    //Pregunta 3
    lateinit var P3a: CheckBox
    lateinit var P3b: CheckBox
    lateinit var P3c: CheckBox
    lateinit var P3t: TextView

    //Pregunta4
    lateinit var P4a: CheckBox
    lateinit var P4b: CheckBox
    lateinit var P4c: CheckBox
    lateinit var P4t: TextView

    //Pregunta 5
    lateinit var P5a: CheckBox
    lateinit var P5b: CheckBox
    lateinit var P5c: CheckBox
    lateinit var P5t: TextView

    //Pregunta 6
    lateinit var P6a: CheckBox
    lateinit var P6b: CheckBox
    lateinit var P6c: CheckBox
    lateinit var P6t: TextView

    //Pregunta 7
    lateinit var P7a: CheckBox
    lateinit var P7b: CheckBox
    lateinit var P7c: CheckBox
    lateinit var P7t: TextView

    //Pregunta 8
    lateinit var P8a: CheckBox
    lateinit var P8b: CheckBox
    lateinit var P8c: CheckBox
    lateinit var P8t: TextView

    //Pregunta 9
    lateinit var P9a: CheckBox
    lateinit var P9b: CheckBox
    lateinit var P9c: CheckBox
    lateinit var P9t: TextView


    lateinit var boton: Button
    lateinit var Puntos: TextView
    var ContadorGlobal: Int = 0


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pregunta 0
        P0a = findViewById(R.id.p0a)
        P0b = findViewById(R.id.p0b)
        P0c = findViewById(R.id.p0c)
        P0t = findViewById(R.id.p0t)

        //Pregunta1
        P1a = findViewById(R.id.p1a)
        P1b = findViewById(R.id.p1b)
        P1c = findViewById(R.id.p1c)
        P1t = findViewById(R.id.p1t)

        //Pregunta2
        P2a = findViewById(R.id.p2a)
        P2b = findViewById(R.id.p2b)
        P2c = findViewById(R.id.p2c)
        P2t = findViewById(R.id.p2t)

        //Pregunta3
        P3a = findViewById(R.id.p3a)
        P3b = findViewById(R.id.p3b)
        P3c = findViewById(R.id.p3c)
        P3t = findViewById(R.id.p3t)

        //Pregunta
        P4a = findViewById(R.id.p4a)
        P4b = findViewById(R.id.p4b)
        P4c = findViewById(R.id.p4c)
        P4t = findViewById(R.id.p4t)

        //Pregunta
        P5a = findViewById(R.id.p5a)
        P5b = findViewById(R.id.p5b)
        P5c = findViewById(R.id.p5c)
        P5t = findViewById(R.id.p5t)

        //Pregunta
        P6a = findViewById(R.id.p6a)
        P6b = findViewById(R.id.p6b)
        P6c = findViewById(R.id.p6c)
        P6t = findViewById(R.id.p6t)

        //Pregunta
        P7a = findViewById(R.id.p7a)
        P7b = findViewById(R.id.p7b)
        P7c = findViewById(R.id.p7c)
        P7t = findViewById(R.id.p7t)

        //Pregunta
        P8a = findViewById(R.id.p8a)
        P8b = findViewById(R.id.p8b)
        P8c = findViewById(R.id.p8c)
        P8t = findViewById(R.id.p8t)

        //Pregunta
        P9a = findViewById(R.id.p9a)
        P9b = findViewById(R.id.p9b)
        P9c = findViewById(R.id.p9c)
        P9t = findViewById(R.id.p9t)


        boton = findViewById(R.id.button)
        Puntos = findViewById(R.id.puntos)





        boton.setOnClickListener() {
            comprobarp1(P0a, P0b, P0c, "verdadera", "falsa", "falsa", P0t)
            comprobarp1(P1a, P1b, P1c, "falsa", "verdadera", "falsa", P1t)
            comprobarp1(P2a, P2b, P2c, "verdadera", "falsa", "falsa", P2t)
            comprobarp1(P3a, P3b, P3c, "verdadera", "falsa", "verdadera", P3t)
            comprobarp1(P4a, P4b, P4c, "verdadera", "falsa", "falsa", P4t)
            comprobarp1(P5a, P5b, P5c, "verdadera", "verdadera", "falsa", P5t)
            comprobarp1(P6a, P6b, P6c, "verdadera", "falsa", "falsa", P6t)
            comprobarp1(P7a, P7b, P7c, "verdadera", "falsa", "verdadera", P7t)
            comprobarp1(P8a, P8b, P8c, "verdadera", "falsa", "falsa", P8t)
            comprobarp1(P9a, P9b, P9c, "falsa", "verdadera", "falsa", P9t)
            Puntos.text = "El resultado final es de: ${(ContadorGlobal * 10) / 13} pts"
        }
    }

    //Metodos

    fun comprobarp1(
        cb1: CheckBox,
        cb2: CheckBox,
        cb3: CheckBox,
        respuesta1: String,
        respuesta2: String,
        respuesta3: String,
        fallos: TextView
    ) {

        val arraycheckbox = arrayOf(cb1, cb2, cb3)
        val respuestas = arrayOf(respuesta1, respuesta2, respuesta3)
        val correccion = arrayOfNulls<Boolean>(3)
        var contador = 0
        //Posibles casos

        for ((index, value) in arraycheckbox.withIndex()) {

            if (value.isChecked) {
                if (respuestas[index].equals("verdadera")) {
                    correccion[index] = true
                    ContadorGlobal++
                } else {
                    correccion[index] = false
                }
            }

            if (!value.isChecked) {
                if (respuestas[index].equals("falsa")) {
                    correccion[index] = true
                } else correccion[index] = false
            }
        }

        //Indicar que apartado de las respuestas es correcto
        for ((index, value) in correccion.withIndex()) {
            if (!value!!) {
                if (fallos.text.toString() == "") {

                    fallos.text = "La respuesta ${index + 1} es incorrecta "
                } else {
                    fallos.text =
                        fallos.text.toString() + "\nla respuesta ${index + 1} es incorrecta"
                }
            }
        }
    }
}















