package org.example.entregagui.Dao;

import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Pelotones;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PelotonesDAOImpl implements PelotonesDAO {

    @Override
    public void añadirPeloton(Pelotones peloton) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.persist(peloton);
        tx.commit();
        session.close();
    }

    @Override
    public void borrarPeloton(Pelotones peloton) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.remove(peloton);
        tx.commit();
        session.close();
    }

    @Override
    public void modificarPeloton(Pelotones peloton) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.merge(peloton);
        tx.commit();
        session.close();
    }

    @Override
    public ArrayList<Pelotones> listarPelotones() {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        ArrayList<Pelotones> lista = (ArrayList<Pelotones>) session.createQuery("from Pelotones ").list();
        tx.commit();
        session.close();
        return lista;
    }
}
