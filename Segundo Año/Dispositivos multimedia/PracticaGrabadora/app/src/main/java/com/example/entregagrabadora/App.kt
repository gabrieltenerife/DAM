package com.example.entregagrabadora

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.IOException

class App : AppCompatActivity() {

    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var audioFilePath: String = ""

    private lateinit var grabarButton: Button
    private lateinit var detenerGrabarButton: Button
    private lateinit var reproducirButton: Button
    private lateinit var estadoTextView: TextView
    private lateinit var texto: EditText
    private lateinit var borrarButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        grabarButton = findViewById(R.id.boton1)
        detenerGrabarButton = findViewById(R.id.boton2)
        reproducirButton = findViewById(R.id.button3)
        estadoTextView = findViewById(R.id.tv1)
        texto = findViewById(R.id.texto)
        borrarButton = findViewById(R.id.button4)

        var bundle = intent.extras
        var idString = bundle?.getString("id")
        var id = idString?.toInt()

        detenerGrabarButton.isEnabled = false
        reproducirButton.isEnabled = false
        estadobotonreproducir(texto)

// Verifica los permisos necesarios
        solicitarPermisos()

// Evento onClick para el botón "Grabar"

        grabarButton.setOnClickListener {
            if (texto.text.isNotEmpty()) {
                if (id != null) {
                    iniciarGrabacion(audioFilePath, id)
                }
            } else Toast.makeText(this, "Introduzca un nombre para el archivo", Toast.LENGTH_SHORT)
                .show()
        }

// Evento onClick para el botón "Detener Grabación"
        detenerGrabarButton.setOnClickListener {
            detenerGrabacion()
        }

// Evento onClick para el botón "Reproducir Grabación"
        reproducirButton.setOnClickListener {
            if (id != null) {
                reproducirGrabacion(audioFilePath, id)
            }
        }

        //Evento onClick para el boton "borrarButton"
        borrarButton.setOnClickListener {
            if (id != null) {
                borrararchivo(id)
            }
        }
    }


    // Función para verificar y solicitar permisos
    private fun solicitarPermisos() {
        val permisos = arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

// Solicita permisos si no están otorgados
        if (!permisos.all {
                ContextCompat.checkSelfPermission(this, it) ==
                        PackageManager.PERMISSION_GRANTED
            }) {
            ActivityCompat.requestPermissions(this, permisos, 0)
        }
    }

    // Función para iniciar la grabación de audio
    private fun iniciarGrabacion(archivo: String, id: Int) {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()

        registro.put("id", id)
        registro.put("archivo", texto.text.toString())

        val can = db.insert("archivos", null, registro)
        db.close()

        audioFilePath = "${externalCacheDir?.absolutePath}/${texto.text.toString() + id}.3gp"

        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC) // Fuente de audio
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP) // Formato de salida
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB) // Codificador de audio
            setOutputFile(audioFilePath) // Ruta del archivo de salida
            try {
                prepare() // Prepara el MediaRecorder
                start() // Inicia la grabación
                estadoTextView.text = "Grabando..."
                grabarButton.isEnabled = false
                detenerGrabarButton.isEnabled = true
                reproducirButton.isEnabled = false
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    // Función para detener la grabación de audio
    private fun detenerGrabacion() {
        mediaRecorder?.apply {
            stop() // Detiene la grabación
            release() // Libera los recursos
        }
        mediaRecorder = null
        estadoTextView.text = "Grabación detenida."
        grabarButton.isEnabled = true
        detenerGrabarButton.isEnabled = false
        reproducirButton.isEnabled = true
    }

    // Función para reproducir la grabación de audio
    private fun reproducirGrabacion(archivo: String, id: Int) {

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        var variable = texto.text.toString()
        var idstring = id.toString()


        val buscar = db.rawQuery(
            "SELECT archivo FROM archivos WHERE id = ? AND archivo = ?",
            arrayOf(idstring, variable)
        )

        if (buscar.moveToFirst()) {
            audioFilePath = "${externalCacheDir?.absolutePath}/${texto.text.toString() + id}.3gp"
            mediaPlayer = MediaPlayer().apply {
                try {
                    setDataSource(audioFilePath) // Configura la fuente de datos (archivo de audio)
                    prepare() // Prepara el MediaPlayer
                    start() // Inicia la reproducción
                    estadoTextView.text = "Reproduciendo..."
                    // Cambia el estado del TextView cuando finaliza la reproducción
                    setOnCompletionListener {
                        estadoTextView.text = "Reproducción finalizada."
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } else Toast.makeText(this, "Este archivo no existe", Toast.LENGTH_SHORT).show()
    }

    fun borrararchivo(id:Int) {

        audioFilePath = "${externalCacheDir?.absolutePath}/${texto.text.toString() + id}.3gp"
        val archivoAudio = File(audioFilePath)

        if (archivoAudio.exists()) {
            val eliminado = archivoAudio.delete()
            Toast.makeText(this, "Eliminado correctamente", Toast.LENGTH_SHORT).show()
            texto.setText("")
        } else {
            Toast.makeText(this, "Este archivo no existe", Toast.LENGTH_SHORT).show()
        }

    }

    fun estadobotonreproducir(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (texto.text.isEmpty()) {
                    reproducirButton.isEnabled = false
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (texto.text.isEmpty()) {
                    reproducirButton.isEnabled = false
                } else {
                    reproducirButton.isEnabled = true
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (texto.text.isEmpty()) {
                    reproducirButton.isEnabled = false
                } else {
                    reproducirButton.isEnabled = true
                }
            }
        })
    }

    // Función para liberar recursos cuando la actividad se destruye
    override fun onDestroy() {
        super.onDestroy()
        mediaRecorder?.release()
        mediaPlayer?.release()
    }
}