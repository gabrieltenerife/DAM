package org.example.entregagui.Dao;

import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Ciclistas;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class CiclistasDAOImpl implements CiclistasDAO {

    @Override
    public void añadirCiclista(Ciclistas ciclista) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.persist(ciclista);
        tx.commit();
        session.close();
    }

    @Override
    public void borrarCiclista(Ciclistas ciclista) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.remove(ciclista);
        tx.commit();
        session.close();
    }


    @Override
    public void modificarCiclista(Ciclistas ciclista) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.merge(ciclista);
        tx.commit();
        session.close();

    }

    @Override
    public ArrayList<Ciclistas> listarCiclistas() {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        ArrayList<Ciclistas> lista = (ArrayList<Ciclistas>) session.createQuery("from Ciclistas ").list();
        tx.commit();
        session.close();
        return lista;
    }
}


