package org.example.entregagui.Dao;

import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Lesiones;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class LesionesDAOImpl implements LesionesDAO {

    @Override
    public void añadirLesion(Lesiones lesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.persist(lesion);
        tx.commit();
        session.close();
    }

    @Override
    public void borrarLesion(Lesiones lesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.remove(lesion);
        tx.commit();
        session.close();
    }

    @Override
    public void modificarLesion(Lesiones lesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.merge(lesion);
        tx.commit();
        session.close();
    }

    @Override
    public ArrayList<Lesiones> listarLesiones() {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        ArrayList<Lesiones> lista = (ArrayList<Lesiones>) session.createQuery("from Lesiones ").list();
        tx.commit();
        session.close();
        return lista;
    }
}
