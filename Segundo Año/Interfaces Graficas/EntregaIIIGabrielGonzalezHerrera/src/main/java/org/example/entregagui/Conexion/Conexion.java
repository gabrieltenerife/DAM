package org.example.entregagui.Conexion;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Conexion {

    static SessionFactory sf;

    private Conexion() {
        Configuration cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
    }

    public static Session getConexion() {
        if (sf == null) {
            new Conexion();
        }
        return sf.openSession();
    }
}
