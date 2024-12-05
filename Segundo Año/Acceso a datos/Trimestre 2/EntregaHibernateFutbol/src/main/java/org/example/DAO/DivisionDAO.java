package org.example.DAO;

import org.example.Conexion;
import org.example.Model.Division;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DivisionDAO implements DaoCRUD <Division>{
    @Override
    public int create(Division obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        // Método
        session.persist(obj);
        tx.commit();
        session.close();
        return 0;
    }

    @Override
    public ArrayList<Division> read() {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        // Método
        ArrayList<Division> lista = (ArrayList<Division>) session.createQuery("from Division").list();
        tx.commit();
        session.close();
        return lista;
    }

    @Override
    public int update(Division obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        // Método
        session.merge(obj);
        tx.commit();
        session.close();
        return 0;
    }

    @Override
    public int delete(Division obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        // Método
        session.remove(obj);
        tx.commit();
        session.close();
        return 0;
    }
}
