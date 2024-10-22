package com.example.entragaloginencriptacion

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Modificarcontrasena : AppCompatActivity() {

    lateinit var confirmar : Button
    lateinit var contra : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_modificarcontrasena)

        contra = findViewById(R.id.contra)
        confirmar = findViewById(R.id.confir)

        confirmar.setOnClickListener {

            val bundle = intent.extras
            val pass = bundle?.getString("pasword")
            val user = bundle?.getString("usuario")


            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val db = admin.writableDatabase

            if(pass.equals(contra.text.toString())){Toast.makeText(this, "La contraseña no puede ser igual", Toast.LENGTH_SHORT).show()} else {

                val registro = ContentValues()
                registro.put("contraseña", contra.text.toString())
                val cant = db.update("usuarios", registro, "usuario = ?", arrayOf(user))

                if(cant == 1){
                    Toast.makeText(this, "Contraseña cambiada correctamente", Toast.LENGTH_SHORT).show()
                    val intento = Intent(this, MainActivity::class.java)
                    startActivity(intento)

                } else {Toast.makeText(this, "Error no se ha cambiado la contraseña", Toast.LENGTH_SHORT).show()}
            }
        }
    }
}