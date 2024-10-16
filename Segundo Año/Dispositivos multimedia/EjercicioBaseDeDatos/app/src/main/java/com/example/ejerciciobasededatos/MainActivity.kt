package com.example.ejerciciobasededatos

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var TextoCodigo: EditText
    lateinit var TextoDescripcion: EditText
    lateinit var TextoPrecio: EditText

    lateinit var BotonAlta: Button
    lateinit var BotonConsutaCo: Button
    lateinit var BotonConsultaDe: Button
    lateinit var BotonCodigoBaja: Button
    lateinit var BotonModificar: Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        TextoCodigo = findViewById(R.id.TextoCodigo)
        TextoDescripcion = findViewById(R.id.TextoDescripcion)
        TextoPrecio = findViewById(R.id.TextoPrecio)

        BotonAlta = findViewById(R.id.BotonAlta)
        BotonConsutaCo = findViewById(R.id.BotonCodigoA)
        BotonConsultaDe = findViewById(R.id.BotonDescipcion)
        BotonCodigoBaja = findViewById(R.id.BotonCodigoB)
        BotonModificar = findViewById(R.id.BotonModificacion)


        BotonAlta.setOnClickListener { alta() }
        BotonConsutaCo.setOnClickListener { consultaporcodigo() }
        BotonConsultaDe.setOnClickListener { consultapordescripcion() }
        BotonCodigoBaja.setOnClickListener { baja() }
        BotonModificar.setOnClickListener { modificar() }

    }

    fun alta() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()

        registro.put("codigo", TextoCodigo.text.toString())
        registro.put("descripcion", TextoDescripcion.text.toString())
        registro.put("precio", TextoPrecio.text.toString())

        db.insert("articulos", null, registro)
        db.close()

        TextoCodigo.setText("")
        TextoPrecio.setText("")
        TextoDescripcion.setText("")

        Toast.makeText(this, "Datos cargados correctamente", Toast.LENGTH_SHORT).show()
    }

    fun consultaporcodigo() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val fila = db.rawQuery(
            "select descripcion,precio from articulos where codigo=${TextoCodigo.text.toString()}",
            null
        )

        if (fila.moveToFirst()) {
            TextoDescripcion.setText(fila.getString(0))
            TextoPrecio.setText(fila.getString(1))

        } else {
            Toast.makeText(this, "No existe un articulo con este codigo", Toast.LENGTH_SHORT).show()
        }

        db.close()
    }

    fun consultapordescripcion() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val fila = db.rawQuery(
            "select codigo,precio from articulos where descripcion='${TextoDescripcion.text.toString()}'",
            null
        )

        if (fila.moveToFirst()) {
            TextoCodigo.setText(fila.getString(0))
            TextoPrecio.setText(fila.getString(1))

        } else {
            Toast.makeText(this, "No existe un articulo con este codigo", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun baja() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val cant = db.delete("articulos", "codigo = ${TextoCodigo.text.toString()}", null)

        TextoCodigo.setText("")
        TextoPrecio.setText("")
        TextoDescripcion.setText("")

        if (cant == 1) {
            Toast.makeText(this, "Eliminado correctamente", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "No existe un articulo con este codigo", Toast.LENGTH_SHORT)
            .show()
    }

    fun modificar() {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        val registro = ContentValues()
        registro.put("descripcion", TextoDescripcion.text.toString())
        registro.put("precio", TextoPrecio.text.toString())

        val cant = db.update("articulos", registro, "codigo=${TextoCodigo.text.toString()}", null)
        db.close()

        if (cant == 1) {
            Toast.makeText(this, "Modificado correctamente", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "Este codigo no existe", Toast.LENGTH_SHORT).show()
    }
}