package com.example.proyectoandroid

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.selects.select

class Libreria : AppCompatActivity() {

    lateinit var BotonAñadir: Button
    lateinit var listalibros: ListView

    data class Libro(
        val id_libro: String, val nombre: String, val descripcion: String, val genero: String
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_libreria)

        BotonAñadir = findViewById(R.id.Añadir)
        listalibros = findViewById(R.id.lista)

        var bundle = intent.extras
        var iduser = bundle?.getString("id")


        /*
        * Adaptamos nuestro array de objetos a la lista, en este caso, seleccionamos unicamente el atributo nombre del objeto libro
        * y creamos un nuevo array de nombres que añadimos a la lista y la mostramos.
        * */

        var libros = ListaLibros(iduser)
        var nombresLibros = libros.map { it.nombre }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombresLibros)
        listalibros.adapter = adapter

        BotonAñadir.setOnClickListener {
            if (iduser != null) {
                AñadirLibro(iduser)
            }
        }


        //Al pultsar un objeto dentro de la lista, llamamos al metodo que muestra la descripccion y el genero del libro
        listalibros.setOnItemClickListener { _, _, position, _ ->
            val libroSeleccionado = libros[position]
            mostrarDetallesLibro(libroSeleccionado)
        }

    }

    fun AñadirLibro(iduser: String) {

        val inputLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 40, 50, 10) // Padding opcional para dar espacio
        }

        // Campo para el nombre del libro
        val inputNombre = EditText(this).apply {
            hint = "Nombre del libro"
        }
        inputLayout.addView(inputNombre)

        // Campo para la descripción del libro
        val inputDescripcion = EditText(this).apply {
            hint = "Descripción"
        }
        inputLayout.addView(inputDescripcion)

        // Campo para el género del libro
        val inputGenero = EditText(this).apply {
            hint = "Género"
        }
        inputLayout.addView(inputGenero)

        // Crear el diálogo con los campos
        val dialog = AlertDialog.Builder(this)
            .setTitle("Agregar libro")
            .setView(inputLayout) // Añadir el layout al diálogo
            .setPositiveButton("Aceptar") { dialog, _ ->
                val nombre = inputNombre.text.toString().trim()
                val descripcion = inputDescripcion.text.toString().trim()
                val genero = inputGenero.text.toString().trim()

                // Validación básica (opcional)
                if (nombre.isEmpty()) {
                    Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                    val db = admin.writableDatabase
                    val registro = ContentValues()

                    registro.put("id_usuario", iduser)
                    registro.put("nombre", nombre)
                    registro.put("descripcion", descripcion)
                    registro.put("genero", genero)

                    val can = db.insert("libros", null, registro)
                    db.close()

                    if (can == -1L) {

                        Toast.makeText(
                            this,
                            "Error al insertar",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(this, "Libro añadido correctamente", Toast.LENGTH_SHORT)
                            .show()
                    }

                    // Actualizar la lista después de añadir el libro
                    val nombresLibros = ListaLibros(iduser)
                    val adapter =
                        ArrayAdapter(this, android.R.layout.simple_list_item_1, nombresLibros)
                    listalibros.adapter = adapter

                }
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss() // Cierra el diálogo
            }
            .create()
        dialog.show()
    }

    fun ListaLibros(idUsuario: String?): List<Libro> {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val listaLibros = mutableListOf<Libro>()
        val cursor = db.rawQuery(
            "SELECT nombre, descripcion, genero FROM libros WHERE id_usuario = ?",
            arrayOf(idUsuario.toString())
        )

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))
                val genero = cursor.getString(cursor.getColumnIndexOrThrow("genero"))
                listaLibros.add(Libro(nombre, descripcion, genero, genero))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return listaLibros
    }

    fun mostrarDetallesLibro(libro: Libro) {
        AlertDialog.Builder(this)
            .setTitle(libro.nombre)
            .setMessage("Género: ${libro.genero}\nDescripción: ${libro.descripcion}")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}

