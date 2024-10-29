package com.example.cuestionario20

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cuestionario20.preguntas.Pregunta1

class BienvenidaActivity : AppCompatActivity() {

    lateinit var username: TextView
    lateinit var nota: TextView
    lateinit var testbutton : Button

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenida)

        username = findViewById(R.id.username)
        nota = findViewById(R.id.nota)
        testbutton = findViewById(R.id.testbutton)

        var bundle = intent.extras
        var user = bundle?.getString("usuario")

        username.setText(user)
        nota()

        testbutton.setOnClickListener {
            var intent =  Intent (this, Pregunta1::class.java)
            startActivity(intent)
        }
    }

    fun nota() {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        val buscar = db.rawQuery(
            "SELECT nota FROM usuarios WHERE usuario = ?", arrayOf(username.text.toString())
        )

        if (buscar.moveToFirst()) {
            if (!buscar.getString(0).isNullOrEmpty()) {
                nota.setText("La tu nota maxima es de : ${buscar.getString(0)}")
            } else {
                nota.setText("Realiza un test para obtener tu nota")
            }
        }
    }
}