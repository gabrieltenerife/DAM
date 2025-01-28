package org.example.entregagui.Dao;

import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Recorridos;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class RecorridosDAOImpl implements RecorridosDAO {

    @Override
    public void añadirRecorrido(Recorridos recorrido) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.persist(recorrido);
        tx.commit();
        session.close();
    }

    @Override
    public void borrarRecorrido(Recorridos recorrido) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.remove(recorrido);
        tx.commit();
        session.close();
    }

    @Override
    public void modificarRecorrido(Recorridos recorrido) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.merge(recorrido);
        tx.commit();
        session.close();
    }

    @Override
    public ArrayList<Recorridos> listarRecorridos() {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        ArrayList<Recorridos> lista = (ArrayList<Recorridos>) session.createQuery("from Recorridos ").list();
        tx.commit();
        session.close();
        return lista;
    }
}
