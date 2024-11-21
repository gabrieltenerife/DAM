package com.example.entregagrabadora

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
    usuario TEXT NOT NULL UNIQUE,
    contraseña TEXT NOT NULL,
    id INTEGER PRIMARY KEY AUTOINCREMENT
)
        """
        )

        // Crear tabla archivos con relación a usuarios
        db.execSQL(
            """
            CREATE TABLE archivos (
                id INTEGER,
                archivo TEXT NOT NULL,
                FOREIGN KEY(id) REFERENCES usuarios(id) ON DELETE CASCADE
            )
        """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS archivos")
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }
}
