package com.example.proyectoandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {

        // Crear tabla usuarios con id autoincremental
        db.execSQL(
            """
        CREATE TABLE usuarios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            usuario TEXT NOT NULL UNIQUE,
            contraseña TEXT NOT NULL
        )
        """
        )

        // Crear tabla libros con clave foránea y ON DELETE CASCADE
        db.execSQL(
            """
        CREATE TABLE libros (
            id_libro INTEGER PRIMARY KEY AUTOINCREMENT,
            id_usuario INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            descripcion TEXT,
            genero TEXT,
            FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
        )
        """
        )

        // Crear tabla reunion con claves foráneas y ON DELETE CASCADE
        db.execSQL(
            """
        CREATE TABLE reunion (
            id_reunion INTEGER PRIMARY KEY,
            id_libro INTEGER NOT NULL,
            nombre_libro TEXT,
            id_usuario INTEGER,
            FOREIGN KEY (id_libro) REFERENCES libros(id_libro) ON DELETE CASCADE,
            FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
        )
        """
        )
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        db.execSQL("DROP TABLE IF EXISTS libros")
        db.execSQL("DROP TABLE IF EXISTS reunion")
        onCreate(db)
    }
}