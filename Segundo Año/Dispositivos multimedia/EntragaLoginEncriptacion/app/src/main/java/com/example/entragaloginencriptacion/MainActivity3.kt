package com.example.entragaloginencriptacion

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    lateinit var boton: Button
    lateinit var resultado: TextView
    lateinit var copiar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        boton = findViewById(R.id.button2)
        copiar = findViewById(R.id.copiar)
        resultado = findViewById(R.id.resultado)


        val bundle = intent.extras
        val imprimir = bundle?.getString("encripted")

        resultado.text = imprimir.toString()

        copiar.setOnClickListener {
            copyTextToClipboard(resultado.text.toString())
        }

        boton.setOnClickListener {
            finish()
        }

    }

    private fun copyTextToClipboard(text: String) {
        // Obtener el ClipboardManager
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        // Crear el ClipData con el texto
        val clip = ClipData.newPlainText("Texto Copiado", text)

        // Poner el ClipData en el portapapeles
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this, "Texto copiado al portapapeles", Toast.LENGTH_SHORT).show()
    }
}