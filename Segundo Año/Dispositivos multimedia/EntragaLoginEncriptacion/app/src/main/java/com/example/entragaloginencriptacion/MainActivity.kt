package com.example.entragaloginencriptacion

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var Usuario: EditText
    lateinit var Contraseña: EditText

    lateinit var BotonLogin: Button
    lateinit var BotonSignin: Button
    lateinit var BotonModificar: Button
    lateinit var BotonBorrar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Usuario = findViewById(R.id.Usuario)
        Contraseña = findViewById(R.id.Contraseña)

        BotonLogin = findViewById(R.id.Botonlog)
        BotonSignin = findViewById(R.id.BotonSign)
        BotonModificar = findViewById(R.id.Botonmodi)
        BotonBorrar = findViewById(R.id.Botonborra)


        BotonLogin.setOnClickListener {
            Login()
        }

        BotonSignin.setOnClickListener {
            SignIn()
        }

        BotonModificar.setOnClickListener {
            modificar()
        }

        BotonBorrar.setOnClickListener {
            borrar()
        }

    }

    fun SignIn() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()

        registro.put("usuario", Usuario.text.toString())
        registro.put("contraseña", Contraseña.text.toString())

        val can = db.insert("usuarios", null, registro)
        db.close()

        if (can == -1L) {

            Toast.makeText(
                this,
                "Este nombre de usuario ya esta siendo utilizado",
                Toast.LENGTH_SHORT
            ).show()
            Usuario.setText("")

        } else {

            Usuario.setText("")
            Contraseña.setText("")

            Toast.makeText(this, "Datos cargados correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    fun Login() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = Usuario.text.toString()

        val buscar = db.rawQuery(
            "SELECT contraseña FROM usuarios WHERE usuario = ?",
            arrayOf(variable)
        )

        if (buscar.moveToFirst()) {

            if (buscar.getString(0).equals(Contraseña.text.toString())) {

                var intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
            .show()

        db.close()
    }

    fun modificar() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = Usuario.text.toString()

        val buscar = db.rawQuery(
            "SELECT contraseña FROM usuarios WHERE usuario = ?",
            arrayOf(variable)
        )

        if (buscar.moveToFirst()) {

            if(buscar.getString(0).equals(Contraseña.text.toString())){
                val intento = Intent(this, Modificarcontrasena::class.java)
                intento.putExtra("pasword", Contraseña.text.toString())
                intento.putExtra("usuario", Usuario.text.toString())
                startActivity(intento)
            } else {Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
                .show()}
        } else {Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
            .show()}
    }

    fun borrar() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = Usuario.text.toString()

        val buscar = db.rawQuery(
            "SELECT contraseña FROM usuarios WHERE usuario = ?",
            arrayOf(variable)
        )

        if (buscar.moveToFirst()) {

            if (buscar.getString(0).equals(Contraseña.text.toString())) {

                val cant = db.delete("usuarios", "usuario = ?", arrayOf(Usuario.text.toString()))

                if (cant == 1) {
                    Toast.makeText(this, "Tu cuenta se elimino correctamente", Toast.LENGTH_SHORT)
                        .show()
                }

                Usuario.setText("")
                Contraseña.setText("")

            } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
            .show()

        db.close()
    }
}