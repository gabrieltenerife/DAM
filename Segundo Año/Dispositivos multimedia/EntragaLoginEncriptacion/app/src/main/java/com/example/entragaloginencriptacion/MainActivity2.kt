package com.example.entragaloginencriptacion

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    lateinit var Boton: Button
    lateinit var Des: Button
    lateinit var Texto: EditText
    lateinit var Spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        Texto = findViewById(R.id.texto)
        Boton = findViewById(R.id.boton)
        Des = findViewById(R.id.des)

        Spinner = findViewById(R.id.spinner)
        val lista = arrayOf(
            "Cifrado texto y numeros",
            "Cifrado solo de numeros",
            "Cifrado solo de texto"
        )
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        Spinner.adapter = adaptador

        Boton.setOnClickListener {
            when (Spinner.selectedItem.toString()) {

                "Cifrado texto y numeros" ->
                    if (Texto.text.isNotBlank()) {
                        val resultado = cifradoCesarAvanzado(
                            Texto.text.toString(),
                            "woiwiadinwr2wadaw214588af8aw8f8"
                        )
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

                "Cifrado solo de numeros" ->
                    if (Texto.text.isNotBlank()) {
                        val resultado =
                            cifradoCesarNumeros(Texto.text.toString(), "231523894723684")
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

                "Cifrado solo de texto" ->
                    if (Texto.text.isNotBlank()) {
                        val resultado =
                            cifradoCesarestandar(Texto.text.toString(), "1142iawd8awkn1b4h3b");
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

            }
        }

        Des.setOnClickListener {
            when (Spinner.selectedItem.toString()) {

                "Cifrado texto y numeros" ->
                    if (Texto.text.isNotBlank()) {
                        var resultado = descifradoCesarAvanzado(
                            Texto.text.toString(),
                            "woiwiadinwr2wadaw214588af8aw8f8"
                        );
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

                "Cifrado solo de numeros" ->
                    if (Texto.text.isNotBlank()) {
                        var resultado =
                            descifradoCesarNumeros(Texto.text.toString(), "231523894723684");
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

                "Cifrado solo de texto" ->
                    if (Texto.text.isNotBlank()) {
                        var resultado =
                            descifradoCesarComplejo(Texto.text.toString(), "1142iawd8awkn1b4h3b");
                        val intento = Intent(this, MainActivity3::class.java)
                        intento.putExtra("encripted", resultado)
                        startActivity(intento)
                    }

            }
        }
    }

    fun cifradoCesarestandar(texto: String, clave: String): String {
        val resultado = StringBuilder()

        // Normalizamos la clave a solo letras y convertimos a minúsculas
        val claveNormalizada = clave.filter { it.isLetter() }.toLowerCase()

        // Recorremos cada carácter del texto a cifrar
        for ((i, caracter) in texto.withIndex()) {
            if (caracter.isLetter()) {
                // Determinamos si el carácter es mayúscula o minúscula
                val base = if (caracter.isUpperCase()) 'A' else 'a'

                // Usamos el carácter de la clave correspondiente, ajustamos el ciclo si es más corta
                val desplazamiento = (claveNormalizada[i % claveNormalizada.length] - 'a') % 26

                // Calculamos el nuevo carácter cifrado
                val nuevoCaracter =
                    ((caracter - base + desplazamiento + 26) % 26 + base.code).toChar()
                resultado.append(nuevoCaracter)
            } else {
                // Si no es una letra, lo dejamos igual
                resultado.append(caracter)
            }
        }
        return resultado.toString()
    }

    fun cifradoCesarNumeros(texto: String, clave: String): String {
        val resultado = StringBuilder()

        // Normalizamos la clave a solo dígitos
        val claveNormalizada = clave.filter { it.isDigit() }

        // Recorremos cada carácter del texto a cifrar
        for ((i, caracter) in texto.withIndex()) {
            if (caracter.isDigit()) {
                // Obtenemos el valor numérico del carácter y el desplazamiento de la clave
                val numeroOriginal = caracter - '0'
                val desplazamiento = (claveNormalizada[i % claveNormalizada.length] - '0') % 10

                // Calculamos el nuevo número cifrado
                val nuevoNumero = (numeroOriginal + desplazamiento) % 10
                resultado.append(nuevoNumero)
            } else {
                // Si no es un número, lo dejamos igual
                resultado.append(caracter)
            }
        }
        return resultado.toString()
    }

    fun cifradoCesarAvanzado(texto: String, clave: String): String {
        val conjunto =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}/?<>,."
        val resultado = StringBuilder()

        // Recorremos cada carácter del texto a cifrar
        for ((i, caracter) in texto.withIndex()) {
            // Encontramos la posición del carácter en el conjunto
            val indexCaracter = conjunto.indexOf(caracter)

            if (indexCaracter != -1) {
                // Usamos el carácter de la clave correspondiente, ajustamos el ciclo si es más corta
                val indexClave = i % clave.length
                val desplazamientoClave = conjunto.indexOf(clave[indexClave])

                // Ciframos sumando el desplazamiento y usamos módulo para mantenernos dentro del conjunto
                val nuevoIndex = (indexCaracter + desplazamientoClave) % conjunto.length
                resultado.append(conjunto[nuevoIndex])
            } else {
                // Si el carácter no está en el conjunto, lo dejamos igual
                resultado.append(caracter)
            }
        }
        return resultado.toString()
    }

    fun descifradoCesarAvanzado(textoCifrado: String, clave: String): String {
        val conjunto =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}/?<>,."
        val resultado = StringBuilder()

        // Recorremos cada carácter del texto cifrado
        for ((i, caracter) in textoCifrado.withIndex()) {
            // Encontramos la posición del carácter en el conjunto
            val indexCaracter = conjunto.indexOf(caracter)

            if (indexCaracter != -1) {
                // Usamos el carácter de la clave correspondiente, ajustamos el ciclo si es más corta
                val indexClave = i % clave.length
                val desplazamientoClave = conjunto.indexOf(clave[indexClave])

                // Desciframos restando el desplazamiento y usamos módulo para mantenernos dentro del conjunto
                val nuevoIndex =
                    (indexCaracter - desplazamientoClave + conjunto.length) % conjunto.length
                resultado.append(conjunto[nuevoIndex])
            } else {
                // Si el carácter no está en el conjunto, lo dejamos igual
                resultado.append(caracter)
            }
        }

        return resultado.toString()
    }

    fun descifradoCesarNumeros(textoCifrado: String, clave: String): String {
        val resultado = StringBuilder()

        // Normalizamos la clave a solo dígitos
        val claveNormalizada = clave.filter { it.isDigit() }

        // Recorremos cada carácter del texto cifrado
        for ((i, caracter) in textoCifrado.withIndex()) {
            if (caracter.isDigit()) {
                // Obtenemos el valor numérico del carácter y el desplazamiento de la clave
                val numeroCifrado = caracter - '0'
                val desplazamiento = (claveNormalizada[i % claveNormalizada.length] - '0') % 10

                // Calculamos el nuevo número descifrado
                val nuevoNumero = (numeroCifrado - desplazamiento + 10) % 10
                resultado.append(nuevoNumero)
            } else {
                // Si no es un número, lo dejamos igual
                resultado.append(caracter)
            }
        }

        return resultado.toString()
    }

    fun descifradoCesarComplejo(textoCifrado: String, clave: String): String {
        val resultado = StringBuilder()

        // Normalizamos la clave a solo letras y convertimos a minúsculas
        val claveNormalizada = clave.filter { it.isLetter() }.toLowerCase()

        // Recorremos cada carácter del texto cifrado
        for ((i, caracter) in textoCifrado.withIndex()) {
            if (caracter.isLetter()) {
                // Determinamos si el carácter es mayúscula o minúscula
                val base = if (caracter.isUpperCase()) 'A' else 'a'

                // Usamos el carácter de la clave correspondiente, ajustamos el ciclo si es más corta
                val desplazamiento = (claveNormalizada[i % claveNormalizada.length] - 'a') % 26

                // Calculamos el nuevo carácter descifrado, invirtiendo el desplazamiento
                val nuevoCaracter =
                    ((caracter - base - desplazamiento + 26) % 26 + base.code).toChar()
                resultado.append(nuevoCaracter)
            } else {
                // Si no es una letra, lo dejamos igual
                resultado.append(caracter)
            }
        }

        return resultado.toString()
    }
}