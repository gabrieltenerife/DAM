package org.example.Conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionSql {

    static SessionFactory sf;

    private ConexionSql() {
        Configuration cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
    }

    public static Session getConexion() {
        if (sf == null) {
            new ConexionSql();
        }
        return sf.openSession();
    }
}
