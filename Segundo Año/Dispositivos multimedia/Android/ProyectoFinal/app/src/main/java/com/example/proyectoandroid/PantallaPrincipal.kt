package com.example.proyectoandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PantallaPrincipal : AppCompatActivity() {

    lateinit var perfil : ImageView
    lateinit var libros : CardView
    lateinit var mapas : CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_principal)

        perfil = findViewById(R.id.Perfil)
        libros = findViewById(R.id.libro)
        mapas = findViewById(R.id.mapas)

        var bundle = intent.extras
        var iduser = bundle?.getString("id")

        libros.setOnClickListener {
            var intent = Intent(this, Libreria::class.java)
            intent.putExtra("id", iduser)
            startActivity(intent)
        }

        mapas.setOnClickListener {
            var intent = Intent(this, Quedadas::class.java)
            intent.putExtra("id", iduser)
            startActivity(intent)
        }

        perfil.setOnClickListener {
            var intent = Intent(this, Perfil::class.java)
            intent.putExtra("id", iduser)
            startActivity(intent)
        }
    }
}