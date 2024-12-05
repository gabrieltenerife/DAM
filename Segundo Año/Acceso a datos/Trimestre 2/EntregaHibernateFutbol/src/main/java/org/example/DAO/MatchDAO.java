package org.example.DAO;

import org.example.Conexion;
import org.example.Model.Match;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class MatchDAO implements DaoCRUD<Match> {

    @Override
    public int create(Match obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        //Metodo
        session.persist(obj);
        tx.commit();
        session.close();
        return 0;
    }

    @Override
    public ArrayList<Match> read() {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        //Metodo
        ArrayList<Match> lista = (ArrayList<Match>) session.createQuery("from Match").list();
        tx.commit();
        session.close();
        return lista;
    }

    @Override
    public int update(Match obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        //Metodo
        session.merge(obj);
        tx.commit();
        session.close();
        return 0;
    }

    @Override
    public int delete(Match obj) {
        Session session = Conexion.getConexion().openSession();
        Transaction tx = session.beginTransaction();
        //Metodo
        session.remove(obj);
        tx.commit();
        session.close();
        return 0;
    }
}