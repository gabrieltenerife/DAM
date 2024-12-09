package com.example.proyectoandroid

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Quedadas : AppCompatActivity() {

    //PARQUE
    lateinit var btn_apuntar_parque_garcia_sanabria: Button
    lateinit var btn_mapa_parque_garcia_sanabria: ImageView
    lateinit var btn_lista_libros_parque_garcia_sanabria: ImageView

    //PLAZA ESPAÑA
    lateinit var btn_apuntar_plaza_espana: Button
    lateinit var btn_mapa_plaza_espana: ImageView
    lateinit var btn_lista_libros_plaza_espana: ImageView

    //AUDITORIO
    lateinit var btn_apuntar_auditorio_tenerife: Button
    lateinit var btn_mapa_auditorio_tenerife: ImageView
    lateinit var btn_lista_libros_auditorio_tenerife: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quedadas)

        val bundle = intent.extras
        val iduser = bundle?.getString("id")

        // IDs para reuniones
        val REUNION_PARQUE = "1"
        val REUNION_PLAZA = "2"
        val REUNION_AUDITORIO = "3"

        //PARQUE
        btn_apuntar_parque_garcia_sanabria = findViewById(R.id.btn_apuntar_parque_garcia_sanabria)
        btn_mapa_parque_garcia_sanabria = findViewById(R.id.btn_mapa_parque_garcia_sanabria)
        btn_lista_libros_parque_garcia_sanabria =
            findViewById(R.id.btn_lista_libros_parque_garcia_sanabria)

        //PLAZA ESPAÑA
        btn_apuntar_plaza_espana = findViewById(R.id.btn_apuntar_plaza_espana)
        btn_mapa_plaza_espana = findViewById(R.id.btn_mapa_plaza_espana)
        btn_lista_libros_plaza_espana = findViewById(R.id.btn_lista_libros_plaza_espana)

        //AUDITORIO
        btn_apuntar_auditorio_tenerife = findViewById(R.id.btn_apuntar_auditorio_tenerife)
        btn_mapa_auditorio_tenerife = findViewById(R.id.btn_mapa_auditorio_tenerife)
        btn_lista_libros_auditorio_tenerife = findViewById(R.id.btn_lista_libros_auditorio_tenerife)

        //--------------------------------------------------------------------------------------------------------

        // PARA PARQUE
        btn_apuntar_parque_garcia_sanabria.setOnClickListener {
            if (iduser != null) {
                mostrarListaLibrosEnDialog(iduser, REUNION_PARQUE)
            }
        }
        btn_mapa_parque_garcia_sanabria.setOnClickListener {
            abrirMapa("28.4720", "-16.2539", "Parque Garcia Sanabria")
        }
        btn_lista_libros_parque_garcia_sanabria.setOnClickListener {
            mostrarListaLibrosApuntadosEnDialog(REUNION_PARQUE)
        }

        // PARA PLAZA ESPAÑA
        btn_apuntar_plaza_espana.setOnClickListener {
            if (iduser != null) {
                mostrarListaLibrosEnDialog(iduser, REUNION_PLAZA)
            }
        }
        btn_mapa_plaza_espana.setOnClickListener {
            abrirMapa("28.4673", "-16.2472", "Plaza España")
        }
        btn_lista_libros_plaza_espana.setOnClickListener {
            mostrarListaLibrosApuntadosEnDialog(REUNION_PLAZA)
        }

        // PARA AUDITORIO
        btn_apuntar_auditorio_tenerife.setOnClickListener {
            if (iduser != null) {
                mostrarListaLibrosEnDialog(iduser, REUNION_AUDITORIO)
            }
        }
        btn_mapa_auditorio_tenerife.setOnClickListener {
            abrirMapa("28.4561", "-16.2513", "Auditorio Tenerife")
        }
        btn_lista_libros_auditorio_tenerife.setOnClickListener {
            mostrarListaLibrosApuntadosEnDialog(REUNION_AUDITORIO)
        }

    }

    private fun abrirMapa(lat: String, lng: String, gps: String) {
        val intent = Intent(this, Maps::class.java)
        intent.putExtra("lat", lat)
        intent.putExtra("lng", lng)
        intent.putExtra("gps", gps)
        startActivity(intent)
    }

    private fun mostrarListaLibrosEnDialog(iduser: String, idreunion: String) {
        val listaLibros = ListaLibros(iduser)
        val nombresLibros = listaLibros.map { it.nombre }.toTypedArray()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona un libro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombresLibros)
        builder.setAdapter(adapter) { dialog, which ->
            val libroSeleccionado = listaLibros[which]
            apuntar(iduser, idreunion, libroSeleccionado.id_libro)
            dialog.dismiss()
        }
        builder.setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
        builder.create().show()
    }

    private fun mostrarListaLibrosApuntadosEnDialog(idreunion: String) {
        val listaLibros = mostrarNombresLibrosApuntadosPorReunion(idreunion.toInt())

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Libros apuntados en esta reunión")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLibros)
        builder.setAdapter(adapter, null)
        builder.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        builder.create().show()
    }

    private fun mostrarNombresLibrosApuntadosPorReunion(idReunion: Int): MutableList<String> {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.readableDatabase
        val nombresLibros = mutableListOf<String>()

        val query = """
        SELECT nombre_libro
        FROM reunion
        WHERE id_reunion = ?
    """
        val cursor = db.rawQuery(query, arrayOf(idReunion.toString()))

        cursor.use {
            if (it.moveToFirst()) {
                do {
                    val nombreLibro = it.getString(it.getColumnIndexOrThrow("nombre_libro"))
                    nombresLibros.add(nombreLibro)
                } while (it.moveToNext())
            }
        }
        return nombresLibros
    }


    private fun apuntar(iduser: String, idreunion: String, idlibro: String) {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        // Obtenemos el nombre del libro
        val cursor = db.rawQuery(
            "SELECT nombre FROM libros WHERE id_libro = ? AND id_usuario = ?",
            arrayOf(idlibro, iduser)
        )
        var nombreLibro = ""
        if (cursor.moveToFirst()) {
            nombreLibro = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
        }
        cursor.close()

        // Comprobar si el usuario ya está apuntado a esta reunión
        val cursorReunion = db.rawQuery(
            "SELECT * FROM reunion WHERE id_usuario = ? AND id_reunion = ?",
            arrayOf(iduser, idreunion)
        )

        if (cursorReunion.moveToFirst()) {
            // Si ya está apuntado, muestra un mensaje de error
            Toast.makeText(this, "Ya estás apuntado a esta reunión", Toast.LENGTH_SHORT).show()
        } else {
            // Si no está apuntado, añade el registro en la tabla reunion
            val registro = ContentValues().apply {
                put("id_reunion", idreunion)
                put("id_libro", idlibro)
                put("nombre_libro", nombreLibro)  // Guardamos el nombre del libro
                put("id_usuario", iduser)
            }

            val can = db.insert("reunion", null, registro)
            if (can == -1L) {
                Toast.makeText(this, "Error al apuntarse a la reunión", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Apuntado correctamente a la reunión", Toast.LENGTH_SHORT)
                    .show()

                // Aquí eliminamos el libro de la librería después de apuntarse a la reunión
                val cant =
                    db.delete("libros", "id_libro = ? AND id_usuario = ?", arrayOf(idlibro, iduser))
                if (cant == 1) {
                    Toast.makeText(
                        this,
                        "Libro eliminado de la librería correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Error al eliminar el libro de la librería",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        cursorReunion.close()
        db.close()
    }


    private fun ListaLibros(idUsuario: String?): List<com.example.proyectoandroid.Libreria.Libro> {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.readableDatabase
        val listaLibros = mutableListOf<com.example.proyectoandroid.Libreria.Libro>()
        val cursor = db.rawQuery(
            "SELECT id_libro, nombre, descripcion, genero FROM libros WHERE id_usuario = ?",
            arrayOf(idUsuario.toString())
        )

        cursor.use {
            if (it.moveToFirst()) {
                do {
                    val id_libro = it.getString(it.getColumnIndexOrThrow("id_libro"))
                    val nombre = it.getString(it.getColumnIndexOrThrow("nombre"))
                    val descripcion = it.getString(it.getColumnIndexOrThrow("descripcion"))
                    val genero = it.getString(it.getColumnIndexOrThrow("genero"))
                    listaLibros.add(
                        com.example.proyectoandroid.Libreria.Libro(
                            id_libro,
                            nombre,
                            descripcion,
                            genero
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return listaLibros
    }
}
