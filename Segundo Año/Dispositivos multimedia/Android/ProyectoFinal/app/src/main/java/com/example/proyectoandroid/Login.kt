package com.example.proyectoandroid

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    lateinit var ayuda: ImageView

    lateinit var Usuario: EditText
    lateinit var Contraseña: EditText

    lateinit var BotonLogin: Button
    lateinit var BotonSignin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ayuda = findViewById(R.id.imageView3)

        Usuario = findViewById(R.id.Usuario)
        Contraseña = findViewById(R.id.Contraseña)

        BotonLogin = findViewById(R.id.Botonlog)
        BotonSignin = findViewById(R.id.BotonSign)



        ayuda.setOnClickListener {
            ayuda()
        }

        BotonLogin.setOnClickListener {
            Login()
        }

        BotonSignin.setOnClickListener {
            SignIn()
        }


    }

    fun ayuda() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Inicio de sesion")
            .setMessage("Porfavor, si no tienes cuenta introduce un usuario y una contraseña para registrarte")
            .setPositiveButton("Aceptar") { _, _ ->
                // Acción al presionar "Aceptar"
            }.create()

        dialog.show()
    }

    fun SignIn() {

        //if (Contraseña.text.length > 5) {
            if (Usuario.text.isNotEmpty() && Contraseña.text.isNotEmpty()) {
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
            } else Toast.makeText(
                this,
                "Ambos campos deben estar rellenos para registrarse",
                Toast.LENGTH_SHORT
            ).show()
        /*
        } else Toast.makeText(
            this,
            "Tu contraseña debe tener al menos 5 caracteres",
            Toast.LENGTH_SHORT
        ).show()

         */
    }

    @SuppressLint("NotConstructor")
    fun Login() {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = Usuario.text.toString()

        val buscar = db.rawQuery(
            "SELECT * FROM usuarios WHERE usuario = ?",
            arrayOf(variable)
        )

        if (buscar.moveToFirst()) {

            if (buscar.getString(1).equals(Contraseña.text.toString())) {

                var intent = Intent(this, PantallaPrincipal::class.java)
                intent.putExtra("id", buscar.getString(2))
                startActivity(intent)

            } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "El usuario o contraseña son erroneos", Toast.LENGTH_SHORT)
            .show()

        db.close()
    }
}