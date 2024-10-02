package com.example.cuestionario

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Creamos las variables
   /*
    lateinit var Numa: EditText
    lateinit var Sum: Button
    lateinit var Pantalla: TextView
   */

    lateinit var P1resc : CheckBox
    lateinit var P1resi : CheckBox
    lateinit var P1resi2 : CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enlazamos con el xml
        //Numa = findViewById(R.id.numa)
        P1resc = findViewById(R.id.p1resc)
        P1resi = findViewById(R.id.p1resi)
        P1resi2 = findViewById(R.id.p1resi2)
    }

    //Metodos

    fun comprobar (cb1: CheckBox, cb2: CheckBox, cb3: CheckBox) {

        var r1 = false
        val r2 = false
        val r3 = false


        if(cb1.text.length == 6) {
            if(cb1.text.substring(6) == "c"){

                if (cb1.isChecked){
                    r1 = true
                } else r1 = false

            }
            else {

                if(cb1.isChecked){
                    r1 = false
                }
            }





        }

    }

}