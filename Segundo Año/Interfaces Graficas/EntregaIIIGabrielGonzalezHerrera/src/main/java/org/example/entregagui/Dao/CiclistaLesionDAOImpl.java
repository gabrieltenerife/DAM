package org.example.entregagui.Dao;

import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.CiclistaLesion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class CiclistaLesionDAOImpl implements CiclistaLesionDAO {

    @Override
    public void añadirCiclistaLesion(CiclistaLesion ciclistaLesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.persist(ciclistaLesion);
        tx.commit();
        session.close();
    }

    @Override
    public void borrarCiclistaLesion(CiclistaLesion ciclistaLesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.remove(ciclistaLesion);
        tx.commit();
        session.close();
    }

    @Override
    public void modificarCiclistaLesion(CiclistaLesion ciclistaLesion) {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        session.merge(ciclistaLesion);
        tx.commit();
        session.close();
    }

    @Override
    public ArrayList<CiclistaLesion> listarCiclistasLesion() {
        Session session = Conexion.getConexion();
        Transaction tx = session.beginTransaction();
        ArrayList<CiclistaLesion> lista = (ArrayList<CiclistaLesion>) session.createQuery("from CiclistaLesion ").list();
        tx.commit();
        session.close();
        return lista;
    }
}
