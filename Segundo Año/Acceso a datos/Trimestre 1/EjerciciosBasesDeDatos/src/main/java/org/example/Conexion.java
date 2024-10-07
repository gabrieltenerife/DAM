package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;

    public Connection getConnection() {
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root", "");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return conexion;
    }
}
