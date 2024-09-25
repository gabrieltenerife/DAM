package com.example.calculadoraintento2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Creamos las variables
    lateinit var Numa: EditText
    lateinit var Numb: EditText

    lateinit var Sum: Button
    lateinit var Res: Button
    lateinit var Mul: Button
    lateinit var Divi: Button
    lateinit var Limp: Button

    lateinit var Pantalla: TextView
    lateinit var Alerta: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enlazamos con el xml
        Numa = findViewById(R.id.numa)
        Numb = findViewById(R.id.numb)

        Sum = findViewById(R.id.sum)
        Res = findViewById(R.id.res)
        Mul = findViewById(R.id.mul)
        Divi = findViewById(R.id.div)
        Limp = findViewById(R.id.clear)

        Pantalla = findViewById(R.id.pantalla)
        Alerta = findViewById(R.id.alert)

        //Listeners
        Sum.setOnClickListener {
            suma()
        }

        Res.setOnClickListener{
            resta()
        }

        Limp.setOnClickListener{
            clear()
        }



    }

    //Metodos
    @SuppressLint("SetTextI18n")
    fun suma (){
        var valor1 = Numa.text.toString()
        var valor2 = Numb.text.toString()
        var resultado = 0

        println(valor1)

        if (valor1.isNotEmpty() && valor2.isNotEmpty()){
            resultado = valor1.toInt() + valor2.toInt()
            Pantalla.text = "Resultado es ${resultado.toString()}"
        } else Alerta.text = "Introduce ambos numeros para operar"

    }

    @SuppressLint("SetTextI18n")
    fun resta () {
        var valor1 = Numa.text.toString()
        var valor2 = Numb.text.toString()
        var resultado = 0

        if(valor1.isNotEmpty() && valor2.isNotEmpty()){

            if (valor1.toInt() > valor2.toInt()) {
                resultado = valor1.toInt() - valor2.toInt()
                Pantalla.text = "El resultado es ${resultado.toString()}"
            } else {
                resultado = valor2.toInt() - valor1.toInt()
                Pantalla.text = "El resultado es ${resultado.toString()}"
            }
        } else Alerta.text = "Introduce ambos numeros para operar"
    }

    fun clear () {
        Pantalla.text = ""
    }

}