package com.example.proyectoandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {

    lateinit var User: TextView
    lateinit var BotonBorrar : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        var bundle = intent.extras
        var idUser = bundle?.getString("id")

        User = findViewById(R.id.Nombre)
        BotonBorrar = findViewById(R.id.borrar)

        if (idUser != null) {
            buscarnombre(idUser)
        }

        BotonBorrar.setOnClickListener {
            mostrarDialogoConfirmacion(idUser!!)
        }

    }

    fun buscarnombre(idUser: String) {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = idUser

        val buscar = db.rawQuery(
            "SELECT usuario FROM usuarios WHERE id = ?",
            arrayOf(variable)
        )

        if (buscar.moveToFirst()) {
            User.setText(buscar.getString(0))
        }
        db.close()
    }

    fun mostrarDialogoConfirmacion(idUser: String) {
        // Crear el diálogo
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar eliminación")
        builder.setMessage("¿Estás seguro de que deseas eliminar tu cuenta? Esta acción no se puede deshacer.")

        // Botón de aceptar
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            borrartodo(idUser) // Llama a la función para borrar la cuenta
            dialog.dismiss() // Cierra el diálogo
        }

        // Botón de cancelar
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss() // Cierra el diálogo sin realizar ninguna acción
        }

        // Mostrar el diálogo
        builder.create().show()
    }


    fun borrartodo(idUser: String) {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        val cant = db.delete("usuarios", "id = ?", arrayOf(idUser))

        if (cant == 1) {
            Toast.makeText(this, "Tu cuenta se elimino correctamente", Toast.LENGTH_SHORT)
                .show()
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        db.close()
    }
}