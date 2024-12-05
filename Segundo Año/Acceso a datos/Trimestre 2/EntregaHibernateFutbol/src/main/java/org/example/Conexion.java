package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Conexion {

    static SessionFactory conexion;

    private Conexion() {
        Configuration c = new Configuration().configure();
        conexion = c.buildSessionFactory();
    }

    public static SessionFactory getConexion() {
        if (conexion == null) {
            new Conexion();
        }
        return conexion;
    }
}
