package com.example.practicacuaderno

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Cuaderno : AppCompatActivity() {

    lateinit var Escritura : EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuaderno)

        Escritura = findViewById(R.id.editTextText2)

        val bundle = intent.extras

        var grosorhorizontales = bundle?.getString("grosorhorizontales")
        var grosorverticales = bundle?.getString("grosorverticales")

        var colorhorizontales = bundle?.getString("colorhorizontales")
        var colorverticales = bundle?.getString("colorverticales")

        val fondo =
            Lienzo(this, grosorhorizontales, grosorverticales, colorhorizontales, colorverticales)

        val layout1 = findViewById<ConstraintLayout>(R.id.layout1)
        layout1.addView(fondo)

    }

    class Lienzo(
        context: Context,
        val grosorhorizontales: String?,
        val grosorverticales: String?,
        val colorhorizontales: String?,
        val colorverticales: String?
    ) : View(context) {

        @SuppressLint("DrawAllocation")
        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(255, 255, 255)

            val ancho = width
            val alto = height

            //--------------------------------------------------------------------------
            val pincel1 = Paint()
            pincel1.strokeWidth = when (grosorhorizontales) {
                "Grosor fino" -> 10f
                "Grosor medio" -> 15f
                "Grosor grueso" -> 20f
                else -> 5f
            }
            pincel1.color = when (colorhorizontales) {
                "Color Rojo" -> Color.RED
                "Color Azul" -> Color.BLUE
                "Color Amarillo" -> Color.YELLOW
                else -> Color.BLACK
            }

            //--------------------------------------------------------------------------

            val pincel2 = Paint()
            pincel2.strokeWidth = when (grosorverticales) {
                "Grosor fino" -> 10f
                "Grosor medio" -> 15f
                "Grosor grueso" -> 20f
                else -> 5f
            }
            pincel2.color = when (colorverticales) {
                "Color Rojo" -> Color.RED
                "Color Azul" -> Color.BLUE
                "Color Amarillo" -> Color.YELLOW
                else -> Color.BLACK
            }

            //--------------------------------------------------------------------------

            for (i in 100..alto step 100) {
                canvas.drawLine(0f, i.toFloat(), ancho.toFloat(), i.toFloat(), pincel1)
            }

            canvas.drawLine(50f, 0f, 50f, alto.toFloat(), pincel2)
            canvas.drawLine(30f, 0f, 30f, alto.toFloat(), pincel2)
        }
    }
}