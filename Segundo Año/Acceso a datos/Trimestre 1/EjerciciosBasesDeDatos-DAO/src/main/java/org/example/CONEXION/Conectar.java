package org.example.CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    static Connection conexion;

    private String url = "jdbc:mysql://localhost:3306/musica";
    private String usuario = "root";
    private String contraseña = "root";

    private Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConexion() {
        if(conexion == null) {
            new Conectar();
        }
        return conexion;
    }

    public static void closeConexion() {
        if(conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
